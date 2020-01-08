# my-retail-web-service

Live Server deployed on AWS using elastic bean stalk

http://myretailservice-env.pm3x79uym7.ap-south-1.elasticbeanstalk.com/swagger-ui.html

Technologies

Java JDK 1.8.0

SpringBoot 2.2.2 Release 

Maven 3.5.0

Local Build Build the application using maven 

mvn clean package

Run As Spring Boot App 

java -jar rest-service-1.0.0.jar

http://localhost:5000/swagger-ui.html for api documentation


Example api calls to get the details of the product with id 13860428

http://localhost:5000/products/13860428

http://myretailservice-env.pm3x79uym7.ap-south-1.elasticbeanstalk.com/products/13860428
