# Simple Spring-boot application
Simple Spring-boot sandbox application that connects to a mysql database provided by another container.

## Build application
The following builds a JAR file as output

Using maven
```
$ mvn package
```

Using Gradle (daemon)
```
$ . /gradlew assemble
```

## Build container
The following builds a container image

```
$ docker build -t urax:0.0.1 .
```

```
$ docker compose build && docker compose run
```

## Build and run for development on local machine
This starts the application with H2 instead of a local installation of Mysql
```
./gradlew bootRun -Dspring.profiles.active=dev
```