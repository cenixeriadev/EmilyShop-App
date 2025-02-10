# Usar una imagen base con OpenJDK 22 (basada en Alpine Linux)
FROM amazoncorretto:23-jdk

# Instalar las dependencias gráficas necesarias usando yum (para Amazon Linux)
RUN yum install -y \
    libXext \
    libXrender \
    libXtst \
    libXi \
    && yum clean all
# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR compilado al contenedor
COPY src/target/Practice.jar /app/Practice.jar

# Copiar las dependencias externas (si no están incluidas en el JAR)
COPY src/lib /app/lib

COPY Recursos /app/Recursos

COPY db /app/db
# Configurar el entorno gráfico (X11)
ENV DISPLAY=host.docker.internal:0.0
ENV LIBGL_ALWAYS_INDIRECT=1

# Comando para ejecutar la aplicación
CMD ["java", "-cp", "Practice.jar:src/lib/*", "Main"]