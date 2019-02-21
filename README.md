# Springboot Test driven development
This application demonstrate test driven development for Rest API using springboot. It exposes single Rest API  /listCustomers which returns list of customers objects. The application consists of a controller, service layer and dao repository. This controller  /listCustomers is developed using TDD. There are two test classes CustomerControllerTest and CustomerRestClientTests


1- CustomerControllerTest.java :- This class is to test the controller layer and is using @WebMvcTest annotation and MockMvc API .
@WebMvcTest annotation can be used to test the controller slice of the application. This annotation is going to scan only the controllers (including RestControllers) you’ve defined and the MVC infrastructure. That’s it. So if your controller has some dependency to other beans from your service layer, the test won’t start until you either load that config yourself or provide a mock for it. This is much faster as we only load a tiny portion of your app and good for 		writing the Unit Tests for the Controller layer.

		MockMvc API, One should use MockMvc when you want to test Server-side of application. MockMvc  considers controller endpoints as the methods of the class and tests method behavior. Spring MVC Test builds on the mock request and response from spring-test and does not require a running servlet container.

2- CustomerRestClientTests.java:- This test class is using TestRestTemplate API and @SpringBootTest
@SpringBootTest annotation will load the fully ApplicationContext. Therefore it is highly used for writing the integration testing in web server environment. This will not use slicing and scan for all the stereotype annotations (@Component, @Service, @Respository and @Controller / @RestController) and loads the full application context. Therefore this is more good at in the context of writing integration testing for the application.

Instructions to the application.
			
RestTemplate API you should use when you want to test Rest Client-side application, RestTemplate sends real HTTP requests to the endpoints.
3- Application setup Instruction and Running the tests

4- Java 8 must be installed and JAVA_HOME variable, and add $JAVA_HOME\bin to PATH environment variable

5- Install Maven version greater than 3, set M2_HOME maven envionment variable and add $M2_HOME\bin to PATH environment variable

6- Open the application in STS or eclipse as maven project

4- Run integration unit test CustomerControllerTest.java and CustomerRestClientTests.java, Run these classes as junit test




