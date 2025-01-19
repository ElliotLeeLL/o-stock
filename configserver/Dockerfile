# Step 1: Use a base image with Maven installed to build the JAR
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Step 2: Copy the entire project into the container
COPY . /app

# Step 3: Build the project using Maven (this will generate the JAR)
RUN mvn clean package

# Step 4: Use OpenJDK image to run the JAR file
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Step 5: Copy the built JAR file from the build stage
# Dynamically grab the JAR file name from the target directory
COPY --from=build /app/target/*.jar /app/app.jar

# Step 6: Run the application
CMD ["java", "-jar", "/app/app.jar"]