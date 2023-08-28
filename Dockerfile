FROM openjdk:17

VOLUME /tmp

EXPOSE 8080

COPY target/coding-exercise-0.2.0-SNAPSHOT.jar ekahau-coding-exercise.jar

ENTRYPOINT ["java","-jar","/ekahau-coding-exercise.jar"]