## Maven build
```
mvn clean install -DskipTests=true
```

## Local
```
mvn clean package
docker build -f Dockerfile . -t muneer2ishtech/ekahau_coding_exercise_springboot:0.2.0-SNAPSHOT
docker run -it muneer2ishtech/ekahau_coding_exercise_springboot:0.2.0-SNAPSHOT
docker compose -f docker-compose.yml up

```