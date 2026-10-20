#This first stage acts as a builder using a maven base image to create the jar

FROM maven:3.9-openjdk-17 AS builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml package

FROM registry.access.redhat.com/ubi8/openjdk-17:1.13-1
USER root
RUN mkdir /app
#Copy the jar created by the first stage
COPY --from=builder /usr/src/app/target/animals-demo-1.0-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java", "-jar", "animals-demo-1.0-SNAPSHOT.jar"]