@echo off
@echo run mysql with docker
docker container stop mysql
docker container rm mysql
docker run --name mysql -p 3306:3306 -e MYSQL_USER=root -e MYSQL_DATABASE=monitoring_dev -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5
