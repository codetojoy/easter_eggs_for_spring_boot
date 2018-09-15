#!/bin/bash 

cd books
gradle clean build
cd ..

mkdir dist
rm dist/*.war
cp books/build/libs/books-0.0.1-SNAPSHOT.jar dist

java -jar dist/books-0.0.1-SNAPSHOT.jar
