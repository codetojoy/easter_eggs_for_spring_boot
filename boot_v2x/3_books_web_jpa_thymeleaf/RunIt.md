
## Info

* SEP 2018
* uses Spring Boot 2.0.5
* changed port to 3130
* server with Gradle
    * `cd books ; gradle bootRun`
* in browser
    * http://localhost:3130/books
* Actuator
    * see books/src/main/resources/application.properties
    * groovy ClientActuator.groovy actuator/env
    * groovy ClientActuator.groovy actuator/health
    * groovy ClientActuator.groovy actuator/ ... etc
    * see https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html

## Older

* `create_project.sh` is just an example of how this project was created

## TODO

* what is this in Maven?
