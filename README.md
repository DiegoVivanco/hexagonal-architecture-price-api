# hexagonal-architecture-price-api
Demo web service using hexagonal architecture for e-commerce company

REST service that exposes an endpoint /price to check the best price of a product according to the date

Resource [GET] /price

Params:
* applicationDate: date you want to check.
* brandId:  id the brand we want to check.
* productId: id the product we want to check.

Response:

     {
       "productId": 35455,
       "brandId": 1,
       "priceList": 1,
       "startDate": "2020-06-14-00.00.00",
       "endDate": "2020-12-31-23.59.59",
       "price": 35.5
     }


Example:
[GET] /price?applicationDate=2020-06-14-16:00:00&productId=35455&brandId=1

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

Import postman collection inside src/main/resources/priceCollection.postman_collection.json directory
