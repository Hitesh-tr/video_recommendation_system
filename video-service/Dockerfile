# Use prebuilt jar from target to avoid network/apt during docker build
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the pre-built jar (ensure you build the project locally first)
COPY target/video-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]
