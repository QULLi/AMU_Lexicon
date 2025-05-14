# Use a stable, slim OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target folder into the container
# Make sure the file name matches your built artifact (e.g., userapp.jar)
COPY target/userapp-1.0.0.jar userapp.jar

# Expose the port that your application listens on (default is 8080)
EXPOSE 8080

# Set the container entry point to run the application
ENTRYPOINT ["java", "-jar", "userapp.jar"]