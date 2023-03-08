FROM eclipse-temurin:19

RUN mkdir /opt/app

# dev\public-sample-repos\gs-rest-service\complete\target\rest-service-complete-0.0.1-SNAPSHOT.jar
COPY build/libs/urax-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/urax-0.0.1-SNAPSHOT.jar"]

