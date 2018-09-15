#!/bin/bash 

cd books
gradle clean build
cd ..

if [ -d dist ]; then
rm -rf dist 
fi 

mkdir dist
cp books/build/libs/books.jar dist

java -jar dist/books.jar
