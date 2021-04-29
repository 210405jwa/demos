# SDLC (Software Development Lifecycle)

Process for planning, creating, and displaying information systems.

The high level steps:

1. Requirements Phase
- If you have an existing system, you evaluate this system so that you can determine the various flaws that exist
- You consult w/ your clients, users, etc. on what functionalities they want in a new iteration of an application
- Performed by Business Analyst (BAs)

2. Analysis Phase
- This is where we analyze the more technical aspects of the project, and it is where we define the new system requirements
- In particular, this is where we address the deficiencies with proposals for improvement
- BAs + Senior members of the dev team

3. Design Phase
- This is where we actually design the new system
- No coding is done yet, the product features are planned out w/ the architecture
    - So this is where we would define endpoints, for example
    - This is where we draw out our various ERDs
    - etc.
- Architects and Senior devs

4. Development Phase
- Software is built
- Code is actually written
- Junior and Senior Devs, etc.

5. Testing Phase
- Software is tested to ensure it functions as intended
- Devs & testers

6. Deployment & Maintenance Phase
- Product is actually delivered/deployed for the customer to use
- Maintenance is rigorously kept up
    - This is where we have monitoring metrics, uptime, etc.
- Operations team

This is a high level description of what steps we take during software development. But, the specific details change depending on what method we use to follow the SDLC.

# Waterfall Method
This is the traditional way of following the SDLC. The main idea is that we complete one phase entirely of the SDLC before we move onto the next phase. 
- Progress is seen as going "downwards" in one direction only
- Best suited for smaller projects or projects where requirements don't really change (maybe Government projects)
- A lot of people consider this approach not as efficient financial-wise
- Cannot go back up the waterfall
    - Waterfall is considered inflexible
- The benefits are we get full outline of the plan before we start
    - Everything is clear in terms of organization
- You don't deliver value until the very end of the project, where you actually deliver and deploy the application to the customer

Often-times, project managers love waterfall because it makes their jobs much easier. If one phase takes longer than expected, all they need to do is adjust the next phases in their length. However, for developers and testers, this could result in "crunch-time" and all sorts of inefficiencies and stress.

# Agile Method
Agile is another method for following the SDLC. Just by its name, you can tell that Agile is meant to be flexible. In particular, the purpose of Agile primarily is to **deliver value faster**. 

- Agile is based on iterative development where requirements and solutions evolve through the collaboration of cross-functional teams (and also customers)
- Agile is a philosophy/mentality
    - It's not "something we do", it's a mindset
    - But we do have frameworks built around the Agile mindset that we do
- There are four key values to Agile (coming from the Agile Manifesto)
    1. Individuals and Interactions over processes and tools
    2. Working software over comprehensive documentation
        - We are not abandoning documentation
        - Documentation is still important, but only if it adds value to the use of your application
    3. Customer collaboration over contract negotiation
    4. Responding to change over following a plan
- There are Agile methods (often called frameworks), which are comprehensive approaches to SDLC
    - "Scrum" is the most common
- Agile practices (closely tied to DevOps)
    - CI/CD or CI/CD/CD 
    - Continuous Integration (CI)
        - The idea or process of continuously merging multiple developers' code into a repository frequently
            - For example, creating different branches for different features, pushing those branches, and then creating pull requests on Github that other developers will review before we can merge that feature branch into the main branch
        - This should happen MULTIPLE times per day. This is meant to prevent large issues from accumulating. The sooner we find issues by having other developers review our pull requests, the smaller the issues will be
        - CI can be automated to some extent
    - Continuous Delivery (CD)
        - This is where we automate the testing of our code. We then can deploy our code "at a push of a button". This is only possible if all of our tests pass
        - With this approach, we generally have everything ready to be deployed, but we have a big "release day" where we actually then deploy the new features.
    - Continuous Deployment (CD)
        - Every change that we make to the codebase that passes all of the stages of the product pipeline (and all of the tests we wrote) is released to the customer immediately. There is no "release day" because features keep being deployed continuously
        - This is valuable because it speeds up feedback that we can receive from the customer

# Agile Scrum Methodology
- In a "Scrum", the project is divided into "sprints"
- Sprint
    - A specified timeline (typically 2 weeks, but could be 1-4 weeks)
    - The timeline of the Sprint is agreed upon during a "Sprint planning meeting"
- User Story
    - Informal, natural language sentence/description of one or more features
    - User stories are written from the perspective of a user
    - They are agreed upon and split during the Spring planning meeting
    - "As a user, when I log in as a regular employee by entering a valid username and password, I should be able to view all of my own reimbursement requests"
- Epic
    - A large body or collection of user stories that can be broken down further

## Roles
- Product Owner
    - The product owner acts as the point of contact between the customer/client and the development team
    - The product owner is the one that prioritizes the user stories in the product backlog
- Scrum Master
    - Facilitator for the Scrum development team
    - Helps to clarify questions and organize the team
    - Spreading awareness and adoption of Scrum to everyone in the organization
- Dev Team: BAs, QAs, Coders
    - This is the team that estimates the amount of effort it would take to complete a user story
        - This has to do with the idea of story points
    - They are the ones who get the user story done
- Scrum Team
    - Dev Team + Product Owner + Scrum Master
    - Recommended team size 5 - 9 people

## Artifacts
- Product Backlog
    - This a collection of all of the user stories that a particular project should have accomplished
    - These user stories in the backlog don't necessarily need to be refined yet
        - Refinement would happen during Sprint planning, or as more details come in from the client
    - Typically we keep track of the product backlog using a tool such as Trello, Asana, Jira, etc.
        - Some Kanban board
- Sprint Backlog
    - A subset of the product backlog that contains the user stories to be completed during the current sprint
    - We choose what items should be completed and move them from the product backlog to the spring backlog
- Burndown Charts and Burnup Charts
    - Graph that shows how many user stories (or story points) are left to complete during the sprint
        - Burnup is the opposite, which shows the amount completed so far

## Meetings (Scrum Rituals)
- Sprint Planning Meeting
    - Plan for what you want to accomplish during the sprint
    - Usually around 4 hours
- Daily Standup Meeting
    - Short meeting that should last only 15 minutes at the most that happens at the beginning of the day for a scrum team
    - You talk about what you did yesterday, what you plan to do today, and if you have any impediments (blockers)
        - A blocker is a person or group you are waiting on to complete a certain task
    - Generally led by the Scrum Master
- Sprint Review Meeting
    - Happens at the end of the Sprint
    - This is where features are showcased that were accomplished during the sprint
    - Here is where it is decided if the product is complete or needs additional work
- Sprint Retrospective Meeting
    - The scrum team meets and talks about what went well, what didn't go well, and what can be done to improve
