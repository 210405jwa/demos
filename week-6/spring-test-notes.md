# Spring Testing
Testing is an extremely important part of any software development. We want to write tests in order to provide a way of quickly validating whether our application logic is functioning as intended, and if we make changes to our code, that we don't break previous functionality. Spring provides us a module, the `spring-test` module, which makes testing easier with Spring.

# Unit Testing
When performing unit testing, we are testing components in isolation, with every dependency of that object being mocked rather than utilizing the real object. The only real object that we would have is the **system under test**. By using mock objects that our system under test requires as dependencies, we can test in isolation for the logic specific to that system under test only. We assume that the logic in the dependencies is fully working as intended by simply programmatically specifying waht we want the method calls to the mock objects to return.

Typically, we utilize Mockito to create most mock objects, but Spring Test also provides other mock objects to us as well:
- Environment
    - Spring provides mock implementations of `Environment` and `PropertySource` abstractions:
        - `MockEnvironment`
        - `MockPropertySource`
- Servlet API
    - `org.springframework.mock.web` package
    - Contains Servlet API mock objects for testing web contexts, controllers, and filters
        - We will make use of `MockHttpSession` (because some of endpoints are protected by our AOP advice)
    - These are intended to be used with MockMvc (which is a part of Spring Test)
- JNDI: used to setup a simple JNDI environment
- Spring Web Reactive: For use in WebFlux applications (reactive programming)

# Integration Testing
When performing unit testing, we are not testing components in isolation, but rather how they all work together. Since a Spring application is made up of many different Spring bean components that are usually Autowired or configured in some other manner (xml config, Java based config) to be injected into one another, we need a way to have this Autowiring be handled in our test environment. Spring Test provides support for integration testing, with the following goals in mind:

- Manage Spring IoC container caching between tests
    - Utilize the same bean container between tests
    - Or we can specify for it to create a new container for each test class, etc.
- Provide dependency injection of different "test fixture instances" (basically the different instances under test, all wired together properly based on our Spring bean configs)
- Provide transaction management when appropriate (such as for DAO operations w/ @Transactional)
- Supply base classes that help w/ writing integration tests

## Context Management And Caching
What is meant by context management is the creation of IoC containers (contexts). If a project has a large number of beans, other configurations such as 100s of Hibernate mappings, etc. then loading up all of the configuration each time for each test class that we run could take a VERY long time. If it takes 30 seconds, 1 minute, etc. for the contexts to load up for each test class, and we have many different integration test classes, this would add up to a lot of time wasted on running tests.

Therefore, caching is a way to reuse the same context for each test. The setup cost is therefore incurred only once, and all subsequent test execution occurs much faster. By default, the same context is reused for each test.

## Dependency Injection of "Test Fixtures"
When we run our tests, we can have Spring Test help to load up our context and then configure instances of our test classes through dependency injection. From there, we can simply @Autowire our various fixtures that we would like to test in our test class. This prevents us from having to do a bunch of manual setup ourselves.

## Transaction Management
When utilizing database persistence such as through Spring ORM (coupled with Hibernate, in our case), or Spring Data (often used w/ Spring Boot), we need to take into account the impact of changes to the state of the database on future tests. If we have operations such as inserting or modifying data, we can't do so outside of a transaction.

By default, our transaction management performed by the TestContext framework creates and rols back a transaction for each test. So, if we have a test that is testing a DAO method that is intended to delete some data (ex. `pirateDAO.deletePirateById(1)`), we can choose to have it delete the data, assert to see if the data is deleted (ex. `pirateDAO.getPirateById(1) == null`) and then simply rollback the change when the test is finished. This means the database returns to the state prior to the execution of the persistence operations in the test. We can, however, have changes committed or rollback turned off as well.

# Spring Testing Annotations
- `@ContextConfiguration`: defines class-level metadata that is used to load and configure our IoC container(s) for integration tests. This is where we specify the location of the context configuration(s).
- `@WebAppConfiguration`: class-level annotation used to declare that the context loaded should be a `@WebApplicationContext` (which extends ApplicationContext). This allows us to properly utilize request scoped beans, session scoped beans, etc. since those are "web-aware" scopes. (ex. HttpServletRequest (request scoped))
- `@ContextHierarchy`: used to define a hierarchy of contexts, if we have two or more contexts in our app. For example, in our demo, we utilize applicationContext.xml AND dispatcherContext.xml. If you remember back to the diagram about the relation between these two contexts, there is a "parent-child" relationship. So we can utilize `@ContextHierarchy` in conjunction w/ `@ContextConfiguration` to establish this relation.
- `@DirtiesContext`: used to indicate that the underlying context(s) have been "dirtied" (modified in some manner) and should be closed and reopened for other tests
- `@Commit`: annotated on a test method to specify that we want the database changes to be committed if that test is a transactional test
- `@Rollback`: indicates whether the transaction for a transactional test should be rolled back. If true, it is rolled back (which is default even without specifying @Rollback). If false, it is committed.

# MockMvc
MockMvc provides support for testing Spring MVC applications. It gives testers the ability to perform request handling through mock request objects and mock response objects rather than running an actual HTTP server (like what we have w/ Tomcat).

We can utilize MockMvc to perform requests and check if the responses are what we should be expecting.

Common static imports used:
- MockMvcBuilders.*: used to help us build a mockMvc object
- MockMvcRequestBuilders.*: used to help us build mock requests
- MockMvcResultMatchers.*: used to help us assert that certain responses contain the information we would expect
- MockMvcResultHandlers.*

## Unit Testing w/ MockMvc
To set up MockMvc for testing a controller independently (w/ various mock dependencies being passed in with something like Mockito, for example):

```java
class MyWebTests {

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        AccountService mockAccountService = mock(AccountService.class); // utilize a mock account service, since we are going to unit test the AccountController, not integration testing

        when(mockAccountService.getAccountById(eq(1))).thenReturn(new Account(1, "user", "pass"));

        // We then instantiate the AccountController using new ourselves (since it is just a POJO
        // from our perspective)
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(mockAccountService)).build();
    }

    @Test
    void test() {

        Account expected = new Account(1, "user", "pass");
        ObjectMapper om = new ObjectMapper();
        String expectedJsonResponse = om.writeValueAsString(expected)

        this.mockMvc.perform(get('account/1'))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedJsonResponse));
    }

}
```

## Integration Testing w/ MockMvc
To set up MockMvc utilizing our Spring configuration, with Spring beans and everything available for integration testing between our components: 

Utilizing JUnit 5 (Jupiter)
```java
@ExtendWith(SpringExtension.class)
@ContextHierarchy({
    @ContextConfiguration("classpath:applicationContext.xml"),
    @ContextConfiguration("classpath:dispatcherContext.xml")
})
@WebAppConfiguration
class MyTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    AccountDAO accountDAO;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        // This will register all of our controllers and everything else that is required
        // with the webApplicationContext

        accountDAO.addAccount(new Account(1, "user", "pass"));
    }

    @Test
    void test() {
        Account expected = new Account(1, "user", "pass");
        ObjectMapper om = new ObjectMapper();
        String expectedJsonResponse = om.writeValueAsString(expected)

        this.mockMvc.perform(get('account/1'))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedJsonResponse));
    }

}
```