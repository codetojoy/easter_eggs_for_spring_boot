
rm *.class

CLASSPATH=.

javac Book.java
javac Books.java

spring run BookController.java
