# Use a base image with Java 17, which is compatible with your project
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your project's target directory into the container
COPY target/demo-1.0.0-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]