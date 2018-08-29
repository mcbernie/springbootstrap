# Simple Bootstrap Project for spring boot

to run this example you need:
- jdk 8
- maven 3.5.4
- mysql <= 5


## Run Project in Standalone mode with 'maven'
```bash
mvn spring-boot:run
```
you cann call _docker-mysql.cmd_ or _docker-mysql.sh_ to run a mysql container in docker

## Run Project with docker
```shell
mvn package 
docker-compose up
```

## Build WAR file
- start an mysql instance ( ex.: docker-mysql script)
- run
    ```sh
    mvn clean package
    ```