#!/usr/bin/env bash
mvn clean
mvn install

cp target/books-catalog-angularjs-1.0-SNAPSHOT.jar /home/evgen/Desktop/books-catalog-angularjs-1.0-SNAPSHOT.jar

java -jar /home/evgen/Desktop/books-catalog-angularjs-1.0-SNAPSHOT.jar
