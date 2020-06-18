FROM openjdk:14-alpine
COPY build/libs/BusinessLogic-*-all.jar BusinessLogic.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "BusinessLogic.jar"]