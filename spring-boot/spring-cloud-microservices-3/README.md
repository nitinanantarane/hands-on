# Springboot-Microservices

### Zipkin Server
- docker run -d -p 9411:9411 openzipkin/zipkin
- http://localhost:9411 

### K8s service registry url
podname-{replica-index}.{ServiceName}.default.svc.cluster.local

### Docker
dockerfile-maven-plugin

- mvn clean package dockerfile:push