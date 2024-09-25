FROM amazoncorretto:19-alpine-jdk
COPY target/agents-1.0-SNAPSHOT.jar agents-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","agents-1.0-SNAPSHOT.jar"]