## Maven build
```
mvn clean install -DskipTests=true
```

## Local
```
mvn clean package
docker build -f Dockerfile . -t muneer2ishtech/ekahau_coding_exercise_springboot:0.3.0-SNAPSHOT
docker run -it muneer2ishtech/ekahau_coding_exercise_springboot:0.3.0-SNAPSHOT
docker compose -f docker-compose.yml up

```
## Run from Docker Hub
- To download the executable docker image and run (without any local build)
- Download `public-docker-compose.yml` from [Github](https://github.com/muneer2ishtech/ekahau-coding-exercise)
  - This to get docker image from [Docker Hub](https://hub.docker.com/repository/docker/muneer2ishtech/ekahau_coding_exercise_springboot)
- To pull the docker image use following command
  - This will get PostgreSQL Docker image also.
```
docker compose -f public-docker-compose.yml pull
```
- To Run the docker image, execute following command
```
docker compose -f public-docker-compose.yml up
```
