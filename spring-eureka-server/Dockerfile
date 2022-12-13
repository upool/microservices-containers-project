#FROM adoptopenjdk:11-jre-hotspot
FROM openjdk:17-jdk
MAINTAINER paulmontoya.net

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-eureka-server.jar

ENTRYPOINT ["java","-jar","/app-eureka-server.jar"]