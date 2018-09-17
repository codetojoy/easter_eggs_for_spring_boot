#!/bin/bash 

cd demo
mvn package
cd ..

if [ -d dist ]; then
rm -rf dist 
fi 

mkdir dist
cp demo/target/demo-0.0.1-SNAPSHOT.jar dist

java -jar dist/demo-0.0.1-SNAPSHOT.jar
