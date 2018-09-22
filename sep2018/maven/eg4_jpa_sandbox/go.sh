#!/bin/bash 

cd demo
mvn package
cd ..

java -jar demo/target/demo-0.0.1-SNAPSHOT.jar
