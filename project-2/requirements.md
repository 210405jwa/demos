# Project 2

Project 2 will be a group-based, full-stack application that you will be designing and implementing based on user stories of your own choosing.

- Backend
    - The backend should be a RESTful API. However you can use stateful authentication through HttpSessions and not be totally stateless
        - Look into Json Web Tokens if you really want to achieve stateless authentication
    - Spring Framework
        - Instead of utilizing Javalin for the backend, you will be using Spring Framework, which has a web module that allows for controllers to be built and mapped
        - Use Spring Web MVC to process HTTP Requests/Responses
    - Hibernate
    - Logback
        - Should have a logback.xml configuration file
    - JUnit tests
        - You should look into how to generate code coverage reports using SonarCloud
        - 3 person teams
            - Minimum of 30% overall code coverage
            - Minimum of 70% service layer code coverage
        - 4 person teams
            - Minimum of 50% overall code coverage
            - Minimum of 80% service layer code coverage
        - Use Mockito as necessary in order to mock the DAO layer, etc.
    - Selenium Tests (End-to-end (E2E) tests)
        - For 3 person teams
            - You should have at least 2 Selenium tests
        - For 4 person teams
            - You should have at least 4 Selenium tests
        - E2E tests don't contribute to code coverage since we are automating actual browser actions and not running tests that are directly interacting with our code like in the case of integration or unit tests
- Frontend
    - You should be using **Angular**
    - You must consume your RESTful API backend
    - **You must also consume a second, external REST API**
        - Please make sure the API you want to use is free and working
        - That way, you do not scramble to revise your project idea when you realize the API either does not work or costs money to use

- AWS Deployment (Frontend + Backend)
    - The frontend and backend should be deployed on your EC2 instance
    - You can utilize the Tomcat server that you set-up on your EC2 to host your backend Spring Framework application
    - You can also deploy static files (.html, .js) containing your Angular frontend through Tomcat as well

- DevOps Pipeline
    - This requirement should likely be saved towards the end, when you have already finished the other requirements
    - You should have a Jenkins pipeline set-up for automated building and deployment of your backend
    - You can also choose to do the same for your frontend

# Steps Each Team Should Complete
As a team, you must
- Decide a project idea to design and implement
- Have a name for your project (very important for your portfolio)
- Have a description of the Project (very important for your portfolio)
    - Professionally worded and phrased
- Have several user stories in the format we have described when talking about agile/scrum
- A list of the technologies you will be using (should be utilizing all of the technologies we have learned (minus Javalin), but it is best to rearticulate this so that you can really drive in the point)

Please create a document containing all of the above information and have one person from the team email it to me. After that point, there will be time to meet me in a breakout so that I can confirm and give the all clear for your project.

The sooner the above steps are completed, the sooner you can start with the project. 

# Project Due Date
Friday, May 21st, 2021