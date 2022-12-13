#FROM adoptopenjdk:11-jre-hotspot
FROM openjdk:17-jdk

#MAINTAINER paulmontoya.net
LABEL org.opencontainers.image.authors="paulmontoya.net"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-admin-server.jar

#EXPOSE 8090
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app-admin-server.jar"]




