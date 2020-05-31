FROM openjdk:11.0.7-jdk-slim AS build
COPY . /src/
WORKDIR /src/
RUN /src/gradlew shadowJar
