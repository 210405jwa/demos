# Behavior Driven Development

**Behavior Driven Development (BDD)** is an approach to software development where developers implement features through the point of view of the various stakeholders. We assume stakeholders lack technical knowledge regarding software development, while developers lack business knowledge. BDD in essence helps us to bridge the gap between business and development teams.

BDD is a super-set of test-driven development, meaning BDD contains the philosophy of TDD, but takes it even further through encouraging effective communication between all parties such that everyone has a strong shared understanding of an application's behavior, not just the development and QA teams.

During the process of developing a feature through BDD,
1. Business analysts and stakeholders collaborate with developers and testers to document expected behaviors in plain language (English-like) syntax
2. Developers/testers write tests to validate the behaviors described
3. Developers then write code to pass the test (this is the TDD part of BDD)

## Benefits of BDD
1. BDD encourages development and maintenance of system documentation that is understandable to both technical and non-technical parties. The documentation produced helps to guide the development process and makes it easier to produce modifications over time. So, this aspect of BDD is commonly referred to as **living documentation**.
2. BDD emphasizes effective communication between the least technical members of the team and the most technical. This can help to greatly improve the quality of the finished product AND the speed at which the product is delivered since it is much clearer what the requirements are for the system.
3. BDD doesn't just help with development, but also the testing of the system as a testing team can generate test cases from the provided scenarios fairly easily

## Implementing BDD With Cucumber
Behavior-driven development has become such an integral part of the Agile development process to the point where there are many dedicated BDD tools such as **Cucumber**.

Implementing BDD with Cucumber is easy since Cucumber follows a standard BDD formula. Cucumber utilizes its own high-level language known as **Gherkin**, which allows developers/BAs to create **feature-files**. The general workflow of Cucumber works as follows:

1. Developers/BAs first write feature files in Gherkin. Feature files define the various scenarios and steps that define a system's behavior at a high level.
2. Once a developer has drafted the feature file, they should run the feature file in order to generate "glue-code". Glue-code refers to the potential test/automation methods that are associated with a scenario's steps. A developer can then choose whether or not to implement those suggested test methods.
    - There are two types of glue code
        - Step definition: contains the various automation/test methods
        - Hooks: contains the methods that should be run before every scenario, after every scenario, etc.
3. Once a developer has generated glue code and written tests, they should choose a test runner to run the glue code.

# Gherkin

Gherkin is a **business readable, domain specific language** that helps us to describe the behaviors of our software. We structure behaviors in the form of scenarios, and write tests around these intended behaviors.

We place Gherkin into **feature files**, which can have **glue code** generated for them. Glue code are the files where actual tests are implemented.

## Scenarios
Scenarios contain steps that are equivalent to test steps. Scenario steps are described through the following keywords (which are case sensitive):

- Given: describes the preconditions
- When: describes the user action
- Then: describes the expected output
- But
- And

An example:
```gherkin
Scenario: Shopping, but already has everything needed from list
    Given I am out shopping
    And I have eggs
    And I have milk
    And I have butter
    When I check my list
    Then I don't need anything else
```

A more concrete example:
```gherkin
Scenario: Logging in Successfully
    Given User is on the login page
    And The username input is present
    And The password input is present
    And The submit button is present
    When User enters a valid username
    And User enters a valid password
    And User presses the submit button
    Then The landing page should be displayed
    But There should not be any display of 'undefined'
```

## Some Terminologies:
- Feature file: A file with a .feature file extension that contains Gherkin syntax in the form of scenarios
- Glue code: Actual Java implementations for our features
    - Step definitions: our actual automation steps / test steps
    - Hooks: blocks of code that run at various parts of the execution cycle, such as before or after scenarios
- Test Runner: a class that contains configuration regarding where to find feature files and definition files and runs the tests, ensuring that each step is defined in a definition file based on the feature file.

## Cucumber Parameterization

There are essentially 3 different forms of parameterization that you might use. What is meant by parameterization is the passing of data from the feature files themselves over to the step definitions in the definition files. This allows us to clearly define parameters that are visible from the perspective of Gherkin itself, and couple it with our actual tests.

So, we have
- The ability to pass parameters "inline"
- The ability to pass parameters in a table
    - Run the step a single time with all of the various data
- The ability to define a "scenario outline" that will run multiple times for each "row" of data
    - If we have x rows, we will run the scenario x times