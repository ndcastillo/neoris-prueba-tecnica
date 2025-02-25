# Usa una imagen base de Java
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el JAR del microservicio
COPY /out/artifacts/ms_cliente_jar/ms-cliente.jar ms-cliente.jar

# Expone el puerto en el que corre el microservicio
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "ms-cliente.jar"]
