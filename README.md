# my-retail-web-service

Live Server deployed on AWS using Elastic Beanstalk

http://myretailservice-env.pm3x79uym7.ap-south-1.elasticbeanstalk.com/swagger-ui.html

Technologies

Java JDK 1.8.0

SpringBoot 2.2.2 Release 

Maven 3.5.0

Used H2 in-memory database for this POC for ease of deployment and testing 

Other Libraries - swagger2 , lombok

Locally Build the application using maven 

mvn clean package

Run the Application using

java -jar rest-service-1.0.0.jar

http://localhost:5000/swagger-ui.html for api documentation


Example API calls

1) Get the product details of the product with ID - 13860428

  http://localhost:5000/products/13860428

  http://myretailservice-env.pm3x79uym7.ap-south-1.elasticbeanstalk.com/products/13860428
