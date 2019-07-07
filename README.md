This is a simple application to connect to a database and read some data to json, as a tech challenge for my interview
with grand.digital.

This project comes with some scripts to handle database setup and teardown. Running `start.sh` will start a docker 
container with a mariadb database, initialize the schema, and populate it with data. Running `stop.sh` will tear it down.

To execute the java application, run `./gradlew run`.