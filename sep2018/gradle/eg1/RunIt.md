
## Info

* SEP 2018
* uses Spring Boot 2.0.5
    * generated on Initialzr website
    * pulled Java code over from ch3-jpa in ~/boot_v2x
* changed port to 7170
* server w/o Gradle
    * `./run_server_no_gradle.sh`
* client
    * groovy Client.groovy 
    * makes a REST call and emits JSON response
    * use-case
        * read books
        * insert book
        * read books again (with new book)
