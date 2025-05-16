# Imagen base de Java
FROM openjdk:17

# Copia el .jar generado al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
