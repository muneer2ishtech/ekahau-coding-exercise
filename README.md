```
mvn clean install -DskipTests=true
docker build . -t muneer2ishtech/springboot_ekahau_coding_excercise:0.2.0-SNAPSHOT
docker run -it muneer2ishtech/springboot_ekahau_coding_excercise:0.2.0-SNAPSHOT
docker-compose up

```