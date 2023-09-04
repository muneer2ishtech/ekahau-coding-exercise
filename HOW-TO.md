
## Build
### Maven build
```
mvn clean install -DskipTests=true
```
or

```
mvn clean package
```

### Docker build
```
docker build -f Dockerfile . -t muneer2ishtech/ekahau_coding_exercise_springboot:0.5.0-SNAPSHOT
```

## Local Run
### Run using Maven
- Without additional ports

```
mvn spring-boot:run
```

- With additional ports

```
mvn spring-boot:run -Dspring-boot.run.arguments="--fi.istech.ekahau.additional-ports=true"
```

### Run using already built Docker image
```
docker run -it muneer2ishtech/ekahau_coding_exercise_springboot:0.5.0-SNAPSHOT
```

### Run using Docker composer
- This will run PostgreSQL together

```
docker compose -f docker-compose.yml up

```

## Docker Hub
### Push to Docker Hub
- You need to sign in to Docker Hub
- Local maven and docker build should be successful

```
docker compose -f docker-compose.yml push

```

### Pull from Docker Hub
```
docker pull muneer2ishtech/ekahau_coding_exercise_springboot:0.5.0-SNAPSHOT
```

## Run Docker Image pulled from Docker Hub
- To download the executable docker image and run (without any local build)
- Download `public-docker-compose.yml` from [Github](https://github.com/muneer2ishtech/ekahau-coding-exercise)
  - This to get docker image from [Docker Hub](https://hub.docker.com/repository/docker/muneer2ishtech/ekahau_coding_exercise_springboot)
- To pull the docker image use following command
  - This will get PostgreSQL Docker image also

```
docker compose -f public-docker-compose.yml pull
```

- To Run the docker image, execute following command

```
docker compose -f public-docker-compose.yml up
```

### To Run with additional port for image pulled from Docker Hub
- To use additional ports for public docker image:
  - In `public-docker-compose.yml`, change `FI_ISTECH_EKAHAU_ADDITIONAL-PORTS` to `true`


## APIs
See [APIs](./README.md#APIs) on how to find APIs to use for application
