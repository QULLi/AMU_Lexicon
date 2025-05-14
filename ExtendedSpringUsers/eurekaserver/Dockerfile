# Use a stable, slim OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the built JAR file from the target folder into the container
# Adjust the file name to match your built artifact (e.g., eurekaserver.jar)
COPY target/eurekaserver-1.0.0.jar eurekaserver.jar

# Expose the port used by the Eureka Server (default is 8761)
EXPOSE 8761

# Define the default command to run the application
ENTRYPOINT ["java", "-jar", "eurekaserver.jar"]