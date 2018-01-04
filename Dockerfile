FROM openjdk:8-alpine
COPY target/spring-project.jar .
ENTRYPOINT ["java","-jar","spring-project.jar"]
