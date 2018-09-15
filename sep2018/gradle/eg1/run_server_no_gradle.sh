#!/bin/bash 

cd demo
gradle clean build
cd ..

if [ -d dist ]; then
rm -rf dist 
fi 

mkdir dist
cp demo/build/libs/demo.jar dist

java -jar dist/demo.jar
