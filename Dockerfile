FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/url-shortener-0.0.1-SNAPSHOT.jar /app/url-shortener.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/url-shortener.jar"]

