# define base docker image
FROM openjdk:15
LABEL maintainer="DigitalCreo Inc"
ADD target/webapp-0.0.1-SNAPSHOT.jar documented-mongodb-springboot.jar
ENTRYPOINT ["java", "-jar", "documented-mongodb-springboot.jar"]
EXPOSE 8085
