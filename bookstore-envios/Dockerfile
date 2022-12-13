#FROM adoptopenjdk:11-jre-hotspot
FROM openjdk:17-jdk
MAINTAINER paulmontoya.net

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bookstore-envios.jar

ENTRYPOINT ["java","-jar","/bookstore-envios.jar"]