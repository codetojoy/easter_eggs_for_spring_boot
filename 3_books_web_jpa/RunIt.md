
# Main

* to create project: `create_project.sh`
* execute: `gradle dependencies`
    * note that `org.springframework.boot:spring-boot-starter-data-jpa: -> 1.4.2.RELEASE`
    * see this on [Maven Central](http://bit.ly/2h1n7HO)
* execute: `gradle bootRun`
* key point is that @SpringBootApplication wraps 3 other major Spring annotations
* note that `data.sql` populates the database
* run `run_client.sh`

# Spring shell

* enable `remote-shell` in `build.gradle` 
* check server for password
* in another terminal, exec: `ssh -p 2000 user@localhost` 
* then: `help`


