FROM openjdk:17

VOLUME /tmp

EXPOSE 8080

COPY target/coding-excercise-0.1.0.jar ekahau-coding-excercise.jar

ENTRYPOINT ["java","-jar","/ekahau-coding-excercise.jar"]