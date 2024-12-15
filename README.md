# Proyecto Spring Boot | PROYECTO FINAL | UTP

Este proyecto utiliza **Spring Boot** como framework principal para desarrollar una aplicación web robusta y escalable. 
Incluye funcionalidades básicas de configuración, controladores, servicios y acceso a bases de datos, con soporte para pruebas unitarias e integración continua.

## Requisitos Previos

Asegúrate de tener instalados los siguientes componentes en tu entorno de desarrollo:

- **Java Development Kit (JDK)** 17 o superior.
- **Maven** 3.8+ o **Gradle** (según la configuración del proyecto).
- **IDE recomendado**: IntelliJ IDEA, Eclipse o VS Code.
- **Base de datos**: MySQL, PostgreSQL u otra compatible (configurable en `application.properties` o `application.yml`).

## Configuración del Entorno

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
   ```

2. Configura el archivo `application.properties` o `application.yml` en el directorio `src/main/resources` para los detalles de conexión a la base de datos:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Compila el proyecto y descarga las dependencias:
   ```bash
   ./mvnw clean install # Si usas Maven
   ./gradlew build      # Si usas Gradle
   ```

## Ejecución del Proyecto

Para ejecutar la aplicación:

```bash
./mvnw spring-boot:run # Con Maven
./gradlew bootRun       # Con Gradle
```

La aplicación estará disponible en: [http://localhost:8080](http://localhost:8080).

## Estructura del Proyecto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.example.app
│   │       ├── controller/  # Controladores REST
│   │       ├── service/     # Lógica de negocio
│   │       ├── repository/  # Acceso a datos
│   │       └── model/       # Entidades JPA
│   └── resources/
│       ├── application.properties # Configuración
│       └── static/                # Archivos estáticos (CSS, JS, imágenes)
└── test/                          # Pruebas unitarias e integración
```

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para la aplicación.
- **Spring Data JPA**: Para la interacción con bases de datos relacionales.
- **Spring Security**: (Opcional) Para la gestión de autenticación y autorización.
- **Thymeleaf** o **React/Vue/Angular**: Para el frontend, según el caso.
- **Lombok**: Reducción del código boilerplate.
- **H2 Database** (opcional): Base de datos en memoria para pruebas.
- **JUnit 5**: Framework de pruebas unitarias.

## Funcionalidades Principales

- Gestión de usuarios (registro, autenticación y autorización).
- CRUD básico para entidades principales.
- Integración con una base de datos relacional.
- API REST para acceso programático.

## Pruebas

Ejecuta las pruebas unitarias con:

```bash
./mvnw test # Para Maven
./gradlew test # Para Gradle
```

Los resultados estarán disponibles en el directorio `target/surefire-reports` o equivalente según el entorno configurado.

## Despliegue

### Despliegue Local

Genera el archivo JAR ejecutable:

```bash
./mvnw package # Con Maven
./gradlew build # Con Gradle
```

Ejecuta el JAR generado:

```bash
java -jar target/tu-archivo.jar
```

### Despliegue en Producción

Configura las siguientes variables de entorno para un despliegue seguro:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

Puedes desplegar en servicios como **Heroku**, **AWS Elastic Beanstalk**, **Azure App Service**, o **Docker**.

### Despliegue con Docker

Crea un archivo `Dockerfile` similar al siguiente:

```dockerfile
FROM openjdk:17-jdk-alpine
COPY target/tu-archivo.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Construye y ejecuta la imagen:

```bash
docker build -t springboot-app .
docker run -p 8080:8080 springboot-app
```

## Contribuciones

¡Las contribuciones son bienvenidas! Por favor, abre un **issue** o envía un **pull request** si deseas colaborar.

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).
