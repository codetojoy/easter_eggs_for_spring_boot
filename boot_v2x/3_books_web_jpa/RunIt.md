
## Info

* SEP 2018
* uses Spring Boot 2.0.5
    * changed some Java from `.save` to `.saveAll`
    * changed some Java to use `IDENTITY` for PK on Book
* changed port to 3130
* server with Gradle
    * `./run_server.sh`
* server w/o Gradle
    * `./run_server_no_gradle.sh`
* client
    * groovy Client.groovy 
    * makes a REST call and emits JSON response
    * use-case
        * read books
        * insert book
        * read books again (with new book)

## Older

* `create_project.sh` is just an example of how this project was created

## TODO

* what is this in Maven?
