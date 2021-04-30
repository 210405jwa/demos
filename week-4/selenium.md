# Selenium

## Introduction
Selenium is an open source project for web browser automation. This means that Selenium consists of software that can control a web browser and perform actions like any human user would, such as navigating to a website, clicking buttons, and filling out forms. Selenium WebDriver is the core of Selenium which provides an API in many different languages for programmers to write code to manipulate the browser.

There are many use cases for Selenium, such as:
- Automated scripts: doing tedious tasks such as filling out a timesheet every week
- Web Scraping: gathering information from website front-ends without needing back-end integrations
- Test Automation: this is probably the main use case, and can be deployed in DevOps pipelines to validate E2E features
- Performance testing: measuring the responsiveness of a webapp accurately and consistently

## Configuring Selenium
- Grab the dependency from mvnrepository and place into our pom.xml

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>
```

- Include the driver of the browser we want to use
    - ChromeDriver for chrome
    - GeckoDriver for firefox
    - ... for Edge

- Configure system property (environment variable) for the WebDriver to know which driver to use

```java
File path = new File("src/main/resources/chromedriver.exe");

System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());

WebDriver driver = new ChromeDriver();
driver.get("http://google.com");
driver.quit();
```

## Main Selenium Classes/Interfaces
- WebDriver: to control the browser window itself
    - WebDriver.findElement(...) to query the DOM for an element
- By: how should we query the DOM?
    - id, className, tagName, CSS selectors, xpath selectors, link text (a tag text), partial link text (a tag text)
- WebElement: represents the HTML elements
- WebDriverWait: used for performing **explicit** waits
- ExpectedCondition: how we specify what to dynamically wait on for certain conditions

## Waits
Sometimes we will get a `NoSuchElementException` when we try to query for an element before it is loaded onto the DOM. In such cases, we want Selenium to wait for the element to appear instead of trying to look for it immediately and throwing an exception. There are two ways of approaching this task:
- Implicit Waits
- Explicit Waits

Implicit waits are a global configuration on the `WebDriver` object and happen every time the DOM is queried. Explicit waits apply individually and adjust the waiting time explicitly and dynamically at regular intervals. For example, if it usually takes 3 seconds for an element to load, you can use an explicit wait to poll at intervals of 200 ms up to a maximum of 5 seconds. As a rule of thumb, you should **ALWAYS use explicit waits**. They are more performant and have well documented and explicitly defined behavior that clearly shows to anyone reading the automation code what it is waiting on. Implicit waits are more of a black box.

Example:

```java
WebElement invalidElement = driver.findElement(By.id("someId")); // Element is not in the DOM yet, NoSuchElementException!

WebDriverWait wdw = new WebDriverWait(driver, 5); // wait a maximum of 5 seconds before throwing an exception

wdw.until(ExpectedConditions.visibilityOfElementLocatedBy(By.id("someid")));

driver.findElement(By.id("someId")).click();
```

There are many other expected conditions that we can use. For example,
- Waiting for an element to exist, be invisible, be clickable, or to contain certain text
- Waiting for the URL or title of the page to match a certain pattern
- Waiting for a certain number of matched elements to appear
- We can even combine wait conditions using `.and()` and `.or()`

## Page Object Model Pattern
Imagine you are trying to automate a single page application. There are multiple views that you need to interact with and many elements to query for. Navigating to pages and repeatedly querying the DOM can result in messy, unorganied code. A simple design pattern to organize our code around would be the **Page Object Model**. Here, we would create one class for every view/page we are interacting with. The fields of this class are the actual elements we perform actions on. We can therefore **encapsulate the state and behavior of each page** as well as **abstracting lower level code away**.

We can also add on to this process of easily creating our page objects by utilizing the `PageFactory` class and `@FindBy` annotations. Here is an example below:

```java
public class LoginPage {
    WebDriver driver;

    // Can have a collection of elements
    @FindBy(class="item")
    List<WebElement> items;

    // Single elements
    @FindBy(id="username")
    WebElement usernameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // We need the PageFactory init method to instantiate the WebElements for 'this' LoginPage object
        PageFactory.init(this.driver, this);
    }

    public WebElement getUsernameInput() {
        return this.usernameInput;
    }

    // ...
}
```

# Building a Test Automation Framework
With Selenium, we have a powerful tool to created automated E2E tests. Large projects often invest a lot of time and resources into building out a **test automation framework**, which have the goal of having an extensible and maintainable framework for creating and running automated tests. The framework should make it really easy to create new tests with minimum effort. 

Test automation frameworks have advantages over manual testing, such as:
- Being more accurate and consistent
- Faster
- Scalable

Often test automation frameworks have test suites that are built into the project's devops pipeline and executed on certain branches or triggered by a pull request. Having efficient automated tests will provide fast feedback to the development team and notify them if new code broke one of the tests.

There are a few different types of frameworks that testers might create:

- Data-driven framework
    - Test data (.csv files, text files, database) is separated and externalized from the test itself
    - Tests read in values from the external test data
    - Useful when the same test case needs to be run with different inputs (for example, logging in with many different username/password combinations)
- Keyword-driven framework
    - Both data and actions are defined outside of the test
    - Actions (click, navigating, typing) define the steps the test should take