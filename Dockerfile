FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/url-shortener-0.0.1-SNAPSHOT.jar /app/url-shortener-java.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/url-shortener-java.jar"]

