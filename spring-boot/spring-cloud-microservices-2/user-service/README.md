# Spring-boot microservices 2
Use JDK11+

### Run Zipkin server
- docker run -d -p 9411:9411 openzipkin/zipkin
- http://localhost:9411

### Run microservices
- run zipkin server
- Run eureka server
- Run config server
- run department, user, hystrix


