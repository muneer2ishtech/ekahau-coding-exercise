FROM openjdk:17

VOLUME /tmp

EXPOSE 8080

COPY target/ekahau-coding-exercise-0.4.0.jar ekahau-coding-exercise.jar

ENTRYPOINT ["java","-jar","/ekahau-coding-exercise.jar"]