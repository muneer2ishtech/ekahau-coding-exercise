FROM openjdk:17

VOLUME /tmp

EXPOSE 8080 8081 8082

COPY target/ekahau-coding-exercise-0.5.0-SNAPSHOT.jar ekahau-coding-exercise.jar

ENTRYPOINT ["java","-jar","/ekahau-coding-exercise.jar"]