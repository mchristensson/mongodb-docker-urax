### Build application

> * The following builds a JAR file as output

Using maven
```
$ mvn package
```

Using Gradle (daemon)
```
$ . /gradlew assemble
```

### Build container
> * The following builds a container image

```
$ docker build -t urax:0.0.1 .
```
```
$ docker-compose build && docker-compose run
```
