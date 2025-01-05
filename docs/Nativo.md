# Nativo

Esta guia presenta los pasos necesarios para configurar el ambiente de desarrollo de forma nativa para: (1) ejecutar pruebas de funcionalidad, (2) ejecutar pruebas de mutación, (3) empaquetar y ejecutar la aplicación

## Pre-requisitos

- Java 11 ([Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) u [OpenJDK](https://openjdk.java.net/install/))
- [Maven](https://maven.apache.org/)

:high_brightness: [SdkMan](https://sdkman.io/) simplifica la gestión de versiones de Java y las herramientas, como Maven (`mvn`).

### 1. Pruebas

Para compilar y correr las pruebas, ubicarse en el mismo directorio que el archivo `pom.xml` e ingresar:

```bash
mvn clean test
```

### 2. Empaquetado

```bash
mvn clean package -DskipTests -Ppackage
```

Esto genera el empaquetado en `target/tp2-0.0.1.jar`.

### 3. Ejecución de la aplicación

```shell script
mvn clean javafx:run
```

La tarea `clean` se encarga de limpiar archivos de compilaciones anteriores. `javafx:run` compila y ejecuta la aplicación.

