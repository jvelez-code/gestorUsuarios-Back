FROM openjdk:8-alpine
ADD target/gestorUsuariosBack2-0.0.1-SNAPSHOT.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]