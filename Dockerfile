FROM openjdk:11
MAINTAINER carwalk
COPY /target/moodtracker-1.0.jar moodtracker-1.0.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker",  "/moodtracker-1.0.jar"]
