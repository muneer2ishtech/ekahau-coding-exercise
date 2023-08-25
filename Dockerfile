FROM postgres:15

ENV POSTGRES_DB: ekdb
ENV POSTGRES_USER: ekuser
ENV POSTGRES_PASSWORD: q&6VP5fp

EXPOSE 5432

FROM openjdk:17

VOLUME /tmp

EXPOSE 8080

COPY target/coding-excercise-0.2.0-SNAPSHOT.jar ekahau-coding-excercise.jar

ENTRYPOINT ["java","-jar","/ekahau-coding-excercise.jar"]