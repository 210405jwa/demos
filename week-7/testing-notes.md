# Testing

## What is Testing?
Testing is about analyzing a software item to detect the differences between required and existing conditions.

- Expected: This is what you would expect to happen if you are following business requirements
- Actual: This is the actual output that you receive when you provide some sort of input

Testing is about finding bugs in your code. 
- Bug: unintended functionality for a piece of software
    - Most of the time, bugs are really hard to detect
    - You might have edge cases that result in the wrong output
    - But maybe your method works overall pretty well
- Error: an error is something that prevents your code from running
    - Compilation errors: your code can't even compile because of syntax errors and therefore can not ever be run
    - In Java we have the concept of exceptions and errors
        - Both of these are "Throwable" (this is the parent class of the Exception class and Error class)
        - But, an Error is intended to represent something that is not really recoverable from
    - In the context of the defect lifecycle, an error is a misunderstanding of requirements 

## Testing Pyramid
- Unit Testing
    - Most micro level of testing
    - Test each component alone without their dependencies
        - This means we have to mock anything that that particular component relies on
        - We usually use Mockito for this purpose
    - JUnit 4, Jupiter (JUnit 5), TestNG
- Integration Testing
    - Test components WITH their dependencies
    - The purpose integration testing is to see whether components work together correctly
    - MockMvc, RestAssured
- System Testing (E2E Testing)
    - Test the entire application as a whole
    - Make sure the entire application works without issues
    - Selenium
        - Automates browsers by interacting with a webpage (for example through Chrome)
        - We can then utilize Selenium with something like JUnit or Jupiter or TestNG in order to write assertions. (we can assert that when we type in a valid username and password, we are displaying an element on the landing page)
- UAT: User Acceptance Testing
    - Test that all requirements / user stories are met
    - We want to simulate the end-user to guarantee that users can realistically perform the actions that they are supposed to
    - Two-Forms: Alpha & Beta Test
        - Alpha Testing is generally performed "in-house"
        - Beta Testing is generally performed out-of-house (usually actual end-users)

### IDE Plugin
- SonarLint: This allows you to quickly see different code smells when you are writing code, so that you never have to worry about cleaning them up later
- EclEmma Java Code Coverage: Provides Code Coverage for JUnit and TestNG unit tests
    - There is a run option called "Coverage As" which runs the tests and provides code coverage reports

# Types of Testing
- Positive & Negative testing
    - Positive: we test a feature behaves correctly when it is used correctly
        - Called the "Happy Path"
        - For example, test to see if our controller has a 200 response when a user supplies a correct username and password
    - Negative: we test a feature behaves correctly with incorrect use
        - For example, test to see if our controller has a 400 response when a user supplies a blank username or password when sending a POST request to /login
- Functional Testing: Any test that validates the actions your application must perform
    - Exploratory Testing: We assume the requirements and validations are based off current behavior of the application
    - Exhaustive Testing: Testing every possible permutation for our application
        - Every possible route that our user could take, such as different combinations of button clicks to see if anything goes wrong with a certain combination or sequence
        - Not really feasible
    - Boundary Testing: Testing the extremes of our application
        - min, max, min - 1, max + 1
    - Equivalence partitioning: Divide up test-values in some equivalent manner
        - Every 25 numbers
        - Negative, Zero, and positive numbers
- Non-Functional Testing: Ensure that the application does not have vulnerabilities
    - Performance testing:
        - Load Testing: Examine how the application behaves under certain loads of connections
            - Anticipated/expected load
        - Stress Testing: Examine how the application behaves under near maximum load
            - Sometimes even overload the application to see if/how it breaks
        - Spike Testing: How does the application behave with a sudden increase in user count
        - Ramp up/ramp down: Gradually increase/decrease load
    - Usability testing: is the application even possible to use?
        - White background with white text
- API Testing: Testing to make sure that the application sends and receives data correctly
- Re-testing: Re-run tests on functionality that failed before to confirm that a defect is fixed
- Regression-testing: run old test-suites to ensure that newly added functionality does not break old functionality. We want to make sure that our application does not "regress".
    - In an actual company environment, it is not always feasible to constantly re-run all of the tests for old features
    - Regression-testing can be expensive, especially for E2E tests, because a lot of E2E tests might not be automated and require manual testing of the application by testers, and automated E2E tests are pretty slow (especially compared to unit tests and integration tests)
    - Regression testing can be expensive
- Smoke Testing & Sanity Testing
    - Both of these types of tests are tests that we should run before we do any regression testing
    - These types of tests are intended to save time by ensuring that we have at least the minimal viable functionality working before we even attempt to test the rest of the application
    - Smoke Testing: Testing used in order to verify critical functionalities of the application
        - This is done to prevent the test team from having to waste time running more sophisicated tests on broken functionality
    - Sanity Testing: Immediately checking to see if newly developed functionality works
- Testing Automation: Perform functional tests utilizing automated scripts to execute, track, and create tests in order to save time and provide test consistency
- Manual Testing
    - We test functionality of our application manually
    - How to:
        - Read and understand guidelines that have written out by the testing team
            - Come from Documents
        - Draft test cases
            - Based on the software specifications/requirements
        - Review test cases w/ team-lead
        - Execute test cases
        - Report defects
            - Standardized process
        - After the defects are fixed, verify that they are fixed
    - Documents
        - Test strategy document: here, we detail how the team handles testing in general
            - This deals with the processes for how much testing should be done
            - Specify what documents and verifications are needed to show that you have done what is expected
        - Test Plan Document: detail how you will test a specific project
            - What processes and conditions are to be utilized for the current project
        - Test Case Document: detail all specific test cases
        - Requirements Traceability Matrix (RTM): Aims to detail every requirement/user story and link it to the test case it pertains to
        - Level of Effort (LOE) Document:
            - Includes Test Strategy, Test Plan, RTM, Test Summary documents
- Black-Box Testing: These are tests where we do not need to understand the code or even have access to the code itself
    - E2E tests can go here
- White-Box Testing: Tests that are based on knowledge of the actual code (such as unit tests, or integration tests)
    - We usually aim for code coverage
    - However, don't write tests simply for the sake of code coverage.
        - You can achieve full code coverage without having tested additional cases more comprehensively

## Defect Lifecycle
- Defect: The result of a failed test
    - Bug: the application behaves in a manner it should not
    - Error: misunderstanding of the requirements
- Feature v. Defect
    - Defects can be viewed as a problem
    - Features are additional functionality that was not requested
- Lifecycle:
    - i. Open a Defect (similar to opening issues on Github)
    - ii. Assign a developer to resolve the defect
        - If the developer says that it is not a defect, then the defect is closed
    - iii. Developer fixes the defect
    - iv. Tester will retest to see if the defect is fixed, otherwise go back to step ii
    - v. Close the defect

## Defect Reports
- While reporting a bug to the developer, sometimes the report will contain the following:
    - Defect ID: Some sort of unique ID for a defect
    - Defect Description: Detailed info about the defect
    - Version
    - Steps: Description of how you can replicate the defect
    - Date
    - Reference: referencing other documents
    - Detected By
    - Fixed By
    - Date Closed
    - Severity
        - Indicate the effect it has on a system's functionality
    - Priority
        - Urgency at which the defect needs to be fixed
    - Screenshots
    - Test Data (if any)
- Severity & Priority
    - High Severity & High Priority: Half of all users cannot login to Facebook
    - High Severity & Low Priority: A very niche feature that is not used by many users is completely broken
    - Low Severity & High Priority: An opposing company's logo is shown on your home page
    - Low Severity & Low Priority: Certain colors are not displaying as expected

## Software Testing Lifecycle
There are many different steps to the software testing lifecycle. You can think this as the "test" phase in the software development lifecycle, which we have already covered.

1. Requirement Analysis: determine what can/should be tested
    - Example:
        - 90% code coverage for the service layer
        - 50% code coverage for DAO layer
        - E2E tests for login, registration, and basic user actions
2. Test Planning:
    - Senior QA will determine cost estimates and have a test plan created
3. Test-case development:
    - Create an develop test-cases and scripts for automated tests
4. Test Environment Setup:
    - We want to have consistent conditions (a certain OS, a certain browser, etc.)
5. Test Execution:
    - Execute the tests according to the Test plan
    - Map defects to Test-cases in the RTM
    - Follow the defect lifecycle (Along with defect reporting)
6. Test Cycle Closure
    - Testing team will meet and talk about how the testing cycle went

## Miscellaneous Topics
- Verification v. Validation
    - Verification: Am I making the right Application?
    - Validation: Have I made the right Application?
- What should I test?
    - Bad answer: "Everything"
        - Testing simply for testing's sake isn't strategic
        - You need to manage resources wisely
        - You should always focus on testing the most important pieces before anything else
    - "The Requirements" is the better answer

## TDD & BDD
- TDD: Test Driven Development
    - Development depends on tests
    - We write test cases first, and then development is done to allow those tests to pass
- BDD: Behavior Driven Development
    - Development occurs based off of collaborations between QA team, BA team, devs, and all other non-technical members
    - Conversations between BAs and client/product owner determine how coding will occur
    - Conversations -> Test Cases -> Development
    - BDD builds on top of TDD, but just helps to more easily bridge the gap between non-technical and technical members by providing the common platform of plain "English" as some sort of specification
        - Ex: Gherkin in the context of Cucumber
- Cucumber: BDD Framework that uses "Gherkin"
    - Gherkin: A Domain Specific Language (DSL) that helps describe business behavior without needing to go into implementation
        - Very high level
        - Supports 70+ real world spoken languages
        - Used to create "feature files"
        - Given-When-Then approach to the syntax
            - ex: Given I am at the login page
            - When I enter a valid username and password
            - Then I should be on the landing page
    - Gluecode: Actual code that is inserted
        - Each step will have a method that is the actual test "steps"
        - Something like JUnit 4, Jupiter (JUnit 5), or TestNG could be used for this gluecode
        - If you're doing an E2E test, utilize Selenium to interact w/ the browser
            - Selenium is just a browser automation tool
            - We use JUnit for writing test syntax and assert conditions
            - Cucumber is for providing this "skeleton" of our tests