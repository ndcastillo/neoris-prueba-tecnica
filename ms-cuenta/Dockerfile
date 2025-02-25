FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/ms-cuenta.jar ms-cuenta.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "ms-cuenta.jar"]
