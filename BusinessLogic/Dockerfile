FROM openjdk:14-alpine

# Health Probe
RUN wget -qO/bin/grpc_health_probe https://github.com/grpc-ecosystem/grpc-health-probe/releases/download/v0.3.3/grpc_health_probe-linux-amd64 && \
    chmod +x /bin/grpc_health_probe

COPY BusinessLogic-*-all.jar BusinessLogic.jar
EXPOSE 1747
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "BusinessLogic.jar"]