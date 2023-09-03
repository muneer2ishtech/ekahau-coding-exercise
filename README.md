```
mvn clean install -DskipTests=true
docker build . -t muneer2ishtech/ekahau_coding_exercise_springboot:0.2.0-SNAPSHOT
docker run -it muneer2ishtech/ekahau_coding_exercise_springboot:0.2.0-SNAPSHOT
docker-compose up

```