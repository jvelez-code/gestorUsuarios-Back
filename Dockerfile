# Usa una imagen base con JDK 11
FROM openjdk:11-jre-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY /target/gestorUsuariosBack222-0.0.1-SNAPSHOT.jar /app/gestorUsuarios.jar

# Establecer la zona horaria
RUN apt-get update && apt-get install -y tzdata && \
    ln -fs /usr/share/zoneinfo/America/Bogota /etc/localtime && \
    dpkg-reconfigure --frontend noninteractive tzdata

# Si tienes otros scripts o archivos, como setenv.sh, puedes copiarlos también
# COPY setenv.sh /app/setenv.sh

# Exponer el puerto que tu aplicación Java estará escuchando
EXPOSE 9898

# Comando para ejecutar la aplicación Java
CMD ["java", "-jar", "gestorUsuarios.jar"]

