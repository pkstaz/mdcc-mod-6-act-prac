# Imagen base apache-php
FROM php:8.0-apache

# Hacemos un update de los paquetes e instalamos vim para poder editar archivos dentro del contenedor
RUN apt-get update && apt-get install -y vim

# Instalamos y activamos el mysqli para poder hacer peticiones a la bbdd de mariadb con php
RUN docker-php-ext-install mysqli && docker-php-ext-enable mysqli

# Ponemos alguna variable de entorno
ENV MARIADB_HOST=mariadb \
    MARIADB_TABLE=tabla_actividad \
    MARIADB_DATABASE=base-de-datos-prueba \
    MARIADB_ROOT_PASSWORD=q1w2e3r4 \
    MARIADB_USER=usuario-prueba

# Damos valor a unos metadatos
LABEL description="Actividad docker build" \
      version="1.0"

# Exponemos el puerto 80
EXPOSE 80

# Establecemos de directorio de trabajo donde estará nuestra pagina web y lógica
WORKDIR /var/www/html/

# Copiamos nuestro archivo index.html
COPY index.html .

# Copiamos nuestros archivos php
COPY *.php .

# Ponemos el entrypoint necesario para arrancar correctamente esta imagen
ENTRYPOINT ["docker-php-entrypoint"]

# Argumento necesario para el entrypoint
CMD ["apache2-foreground"]