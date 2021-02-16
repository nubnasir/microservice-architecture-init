# microservice-architecture-init
Adding all the micro-services features and flavors, so that anyone can clone and build their own micro-service based project

**Current Architecture**

To be added

**item-service**

Items of Seller (create and fetch items).
Used RestTemplate to fetch data from **seller-service**

**seller-service**

Seller organizations

**service-registry**

Netflix eureka server

**cloud-gateway**

Spring Cloud API Gateway to route all the requestes to microservices. Implemented Hystrix, spring actuator

**hystrix-dashboard**

Hystrix dashboard to check monitor all the microservices requestes

**zipkin-server**

Real time distributed log
