# Overview

# What is an API?
API stands for Application Programming Interface, which is an interface that enables two applications to interact with each other according to a collection of software functions and procedures. An API is essentially software code that can be accessed and executed.

For example, think of the different features in Java we have used or looked at:
- String API
- Collections Framework (API)
- Reflection API
- Thread API
- JDBC API

These are collections of classes, abstract classes, and interfaces that define some sort of functionality that we as programmers can use.

But, we are not limited to just what is "built-in" to the JRE runtime library. We have dependencies that we can utilize such as
- MariaDB JDBC Driver
- Javalin
- JUnit
- Mockito
- etc

Even more than this, we can also consider **web services** as being APIs themselves. On the PokeAPI website, for example, we have many different endpoints that allow us to send request to and receive responses which contain a lot of data about pokemon over HTTP. In particular, PokeAPI is an example of a REST API in which we can send a request to retrieve data in the form of a JSON response.

- GET https://pokeapi.co/api/v2/pokemon/ditto
    - We can "invoke" the functionality that retrieves the information about the ditto pokemon

As an analogy, this is almost like a METHOD in Java, just more complex behind the scenes with a bunch of JSON processing, HTTP communication, client-server networking, etc. We send a request (input) and receive a response (output). Similary, methods in Java take arguments, and RETURN some data.

**SO, API is a general term for software we can utilize**. When we build a web application / web service, we are building an API that other applications can use. For example,
- HTML/CSS + JavaScript frontend
    - The JavaScript is the application "logic" for this frontend application
    - It can send HTTP requests to our backend, receive data back
- Angular applications (frontend)
- In project-0, we just use Postman as our "frontend" application

# Web Service
For project-0, the application / API we are building is a **web service** that utilizes HTTP for communication. Through this, we establish a **client/server** relationship between some application that will use this API and the web application itself. (Postman + our Java backend)

The idea of a web service is to provide a common platform that allows many different applications built on many different programming languages to communicate with each other. For example, you could have a JavaScript application send and receive data from another application written in Java. These web services typically utilize HTTP for communication as well as RESTful standards in current modern development.

We have two types of web services that are in common use:
1. SOAP (Simple Object Access Protocol) web services
    - Old and typically not utilized anymore
    - Data is transferred in the form of XML
        - Uses the idea of messages that contain
            - A header
            - A body
    - Use HTTP
2. RESTful web services
    - Lightweight, maintainable, and scalable way of building modern web services
    - Uses primarily JSON to structure data (XML was used in the past)
    - Uses HTTP
    - REpresentational State Transfer
    - Key elements:
        - Requests
            1. Resources: specified within the URI
            2. Request Verbs: GET, POST, PUT, DELETE, PATCH, etc.
            3. Request Headers: metadata sent with our request, such as the type of data we are sending
            4. Request body: data sent with the request
        - Response
            1. Response Headers: metadata sent with the response
            2. Response Body: data sent with the response
            3. Response Status Codes

# HTTP
HTTP stands for HyperText Transfer Protocol. It is one of the protocols in existence that allows us to transfer information, typically over the internet.

HTTP is structured in the form of requests/responses.

## Request
- Request Headers
    - Headers come in the form key - value pairs
    - ex. Content-Type: application/json
- URI
    - Destination of the request
- Query Parameters
    - Additional information that is being used with the request
    - ex. `/clients/{client_id}/accounts?amountLessThan=2000&amountGreaterThan=400`
        - amountLessThan and amountGreaterThan are query parameters
- HTTP Version
- Request Body
- HTTP Method/Verb
    - Information about the goal of the request
    - Examples
        - GET: retrieve information
        - POST: send information
        - PUT: update information
        - DELETE: delete information
        - PATCH: partial update
        - HEAD: same as GET, but does not return a response body, just information in the headers

## Response
- Response Headers
- HTTP Version
- Response Body
- Response Status Codes
    - 1XX Series
        - Informational
    - 2XX Series
        - Successful
        - 200 OK
        - 201 Created
        - 202 Accepted
        - 204 No Content
    - 3XX Series
        - Redirections
        - 300 Multiple Choices
        - 301 Moved Permanently
        - 307 Temporary Redirect
        - 308 Permanent Redirect
    - 4XX Series
        - Client Side Errors
        - 400 Bad Request
        - 401 Unauthorized
        - 403 Forbidden
        - 404 Not Found
        - 418 I'm a Teapot
    - 5XX Series
        - Server Side Error
        - 500 Internal Server Error
        - 501 Not Implemented
        - 502 Bad Gateway
        - 503 Service Unavailable

## Rule of Thumb: Avoid having unhandled exceptions, which will result in 500 responses
As we have already seen with the 5XX series, we typically get a response with a status code of 500 if some sort of exception occurs in our code. We should avoid this by making sure to handle all possible exceptions that could occur and then defining an actual appropriate response code such as 404, or 400, etc. We can do this in Javalin via **exception mapping**.

# REST
- REpresentational State Transfer
- Represent everything on our backend server as a resource
- REST Constraints:
    1. Stateless
        - The server should not save information about a previous request
        - We might need to violate this if we used HttpSessions are any type of session management on our server, but that is fine
        - Applications we build should generally follow some sort of RESTful conventions, with some tweaks here and there potentially
    2. Cacheable
        - If requests occur often enough for the same resource, there should be some ability to have caching for improved performance
        - So, for example, instead of "hitting" the database each time we GET a resource, we might want to cache the resource on the server itself
            - With JDBC/Javalin alone we can't really do this, but if we add Hibernate into the picture, then we can
    3. Uniform Interface
        - this is referring to the URI structure along with having a consistent structure for JSON responses
        - We should have familiar patterns in the response for different requests
    4. Client/Server relationship
        - The API should have some sort of relationship with a client that is using it
        - As resources are changed/added/deleted/etc, we can have some sort of "dynamic" behavior between the two sides.
    5. Layered Architecture
        - The web service/API could be structured as many different servers that communicate to each other, but hidden to the end consumer of the RESTful API
        - The API should function as if the end consumer is only aware of a single destination, even if there are many "nested" servers behind the scenes
    6. Code on Demand (Optional)
        - The server should be able to execute some code on demand for the client to execute
        - Code can be represented as a resource
