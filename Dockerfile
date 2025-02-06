# Usamos una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR desde la carpeta 'target' de tu proyecto al contenedor
COPY target/proyectoVideo-1.0.0.jar app.jar

# Exponemos el puerto en el que la aplicación Spring Boot correrá
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor arranque
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
