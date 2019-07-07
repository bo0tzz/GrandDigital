#!/bin/sh
docker network create db
docker run -d --name mariadb --rm --network db  -e MYSQL_ROOT_PASSWORD=pass1234 -p 3306:3306 mariadb --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
while ! docker run -i --rm --network db mariadb mysqladmin ping -hmariadb --silent; do
  echo 'Waiting...'
  sleep 1
done
cat sql/schema.sql | docker run -i --rm --network db mariadb mysql -hmariadb -uroot -ppass1234
cat sql/data.sql | docker run -i --rm --network db mariadb mysql -hmariadb -uroot -ppass1234
