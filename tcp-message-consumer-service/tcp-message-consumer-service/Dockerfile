# Use Eclipse Temurin JDK 21 (Alpine-based) as the base image
FROM eclipse-temurin:21-jdk-alpine

# Create a non-root user
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Argument for the JAR file
ARG JAR_FILE=*.jar

# Copy the JAR file into the container
COPY ${JAR_FILE} app.jar

# Set the entry point to run the Java application
ENTRYPOINT ["java", "-jar", "/app.jar"]