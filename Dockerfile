#Stage 1: Build the JAR
FROM maven:3.9.9-eclipse-temurin-23 AS build
WORKDIR /app

# Copy only pom.xml first to leverage Docker layer caching for dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Run the JAR
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy only the built JAR from previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Use Spring Boot recommended run command
ENTRYPOINT ["java","-jar","app.jar"]
