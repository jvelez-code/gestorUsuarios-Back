# Usamos una imagen base que tenga Java y NGINX instalados
FROM nginx:latest

# Copiamos el archivo .war a la ubicación de despliegue de NGINX
COPY gestorUsuariosBack.war /usr/share/nginx/html/

# Exponemos el puerto 80 para que pueda ser accedido externamente
EXPOSE 80

# Iniciamos NGINX al ejecutar el contenedor
CMD ["nginx", "-g", "daemon off;"]
