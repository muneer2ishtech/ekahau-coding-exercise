FROM openjdk:17

VOLUME /tmp

EXPOSE 8080

COPY target/coding-excercise-0.2.0-SNAPSHOT.jar ekahau-coding-excercise.jar

ENTRYPOINT ["java","-jar","/ekahau-coding-excercise.jar"]