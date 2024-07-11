#!/usr/bin/env bash

docker run --name springboot-mariadb \
-e MARIADB_ROOT_PASSWORD=my-secret-pw \
-e MARIADB_DATABASE=PERSONS \
-e MARIADB_USER=spring  \
-e MARIADB_PASSWORD=spring \
-p 3306:3306 \
mariadb:latest
