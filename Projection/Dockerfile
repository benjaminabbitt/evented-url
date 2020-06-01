FROM name.benjaminabbitt.evented.wwwwwh.url-build:latest AS build

FROM gcr.io/distroless/java:11 AS runtime
WORKDIR /app
COPY --from=build /src/Projection/build/libs/app.jar /app/app.jar
CMD ["app.jar"]
