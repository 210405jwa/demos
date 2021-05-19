# Maven Build Lifecycle

When we build a project with Maven, it passes through different steps known as phases. These phases are sequential and describe an entire series of phases known as a lifecycle. In particular, this lifecycle is known as the **build lifecycle**. There are other lifecycles for Maven as well, but considering that Maven is primarily a **build tool** and **dependency manager**, the build lifecycle is the most central to our focus with utilizing Maven.

The following phases make up the build lifecycle:
- `validate`: validate that the project is correct w/ all necessary information available and dependencies
- `compile`: compile the source code of our project. This compiled source code (bytecode) will be stored somewhere inside of our target directory
- `test`: test the compiled source code using a suitable unit testing framework. Typically, we utilize the Maven surefire plugin w/ some sort of configuration with a test engine like JUnit or Jupiter in order to execute tests.
- `package`: take the compiled code inside the target directory and package it into an artifact such as a JAR file or a WAR file
- `verify`: run checks on results of integration tests to ensure quality criteria are met.
    - These kinds of integration tests are different than the ones we saw with Spring. For example, we used MockMvc, which tests the controller, service layer, and dao layer together which will generally go into our typical `test` phase and not this phase
    - This phase is more for actually running a live backend server and sending real HTTP requests instead of mock requests w/ something like MockMvc. So, this phase might not even have anything inside of it, which would therefore make it behave similar to `mvn package`
- `install`: install the package into the local Maven repository (analogous to a local Git repository)
- `deploy`: copies the final package to the remote repository for sharing w/ other developers (similar to pushing to Github)

The reason the build lifecycle is referred to as a lifecycle is because of the fact that one phase occurs after another, and you proceed in one direction. You can choose to execute up to a certain phase and not continue with the rest of the phases. For example, we could execute UP TO the package phase by running `mvn package`.