# Spring MVC

## What is Spring MVC?
- Spring MVC (or Spring Model-View-Controller), is a framework built around the concept of model, view, controller that enables web application functionality within the context of Spring
- It is based on the Servlet API
- A special Servlet called the DispatcherServlet is used to dispatch requests to `controller` beans
- Controllers act as the entry-point to the core business logic of the application by invoking the service layer, which then invokes the DAO layer, etc.
- There is also another special component called the ViewResolver, which can be used to handle view templates like JSPs, or static files like HTML

## General Flow of Spring MVC
- The HTTP request is sent to the Servlet engine (Tomcat)
- Tomcat creates the HttpServletRequest object and HttpServletResponse objects
- Tomcat forwards the request and response objects to the DispatcherServlet
    - `org.springframework.web.servlet.DispatcherServlet`
    - This servlet is configured in our web.xml to be the default servlet that is contacted for all of our endpoints not mapped to any other Servlet (using `/` as the url-mapping)
- From there, the DispatcherServlet consults our handler mapping
    - Many different ways of doing this
    - In our case, we're making use of `org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping`
    - We configure this in our applicationContext.xml
        - `<mvc:annotation-driven />
- The handler mapping returns to the DispatcherServlet which Controller to delegate the request to
- The Controller will then receive the request and send a response back to the DispatcherServlet. If a view is required, it will consult the view resolver
- If the view resolver is not required, then it will simply send the response back as data
    - JSON
    - Images
    - Files
    - XML
    - etc.

# Spring MVC annotations
- @Controller: specifies a class as a controller, which is a special bean used to handle web application requests
- @RequestBody: allows Spring to map data from the body of the HTTP request to a Java object
- @ResponseBody: Used to convert a Java object into JSON
- @ResponseStatus: used to mark a method or exception w/ an HTTP response status code
- @RequestParam: used to bind "query parameters" `ex: ?amountLessThan=2000` to a variable
- @PathVariable: used to bind properties in the URL path for a certain method. `ex: /reimbursements/1/image`
- @RequestHeader: We can also map a header's value to a variable
- @RestController: same as @Controller, but implicitly adds @ResponseBody to the controller methods