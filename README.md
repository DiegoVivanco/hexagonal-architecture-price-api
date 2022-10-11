# hexagonal-architecture-price-api
Demo web service using hexagonal architecture for e-commerce company

## Build the project

Run the following command inside projects root directory

    mvn clean install

Requirements:

* Java 11
* Maven

## Run the project

### As JAR file

Run the following commnad inside target directory

    java -jar price-0.0.1-SNAPSHOT.jar

Now type the following url

    http://localhost:8080/actuator/health

#### Healthcheck

This Docker image has a healthcheck statement.

It will be useful for:
* Service status monitoring
* Error recovery
* Dependant services running
* ...

## Browse the database

When active you can browse database from your web browser with this URL

    localhost:8080/h2-console

Use connection data provided in application.properties file

## Browse the API Documentation

Explore the following URL

    http://localhost:8080/swagger-ui.html

## Postman collection for test the api

Import postman collection inside src/main/resources/priceTestCollection.postman_collection.json directory
