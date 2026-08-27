# 🎬 Proyecto Desarrollo Backend

API REST desarrollada con **Java y Spring Boot** para la gestión de películas y géneros cinematográficos.

El proyecto utiliza **Spring Data JPA / Hibernate** para la persistencia de información y **PostgreSQL** como base de datos.

## 🚀 Tecnologías utilizadas

- ☕ Java 17
- 🌱 Spring Boot 4.1.1
- 🌐 Spring Web
- 🗄️ Spring Data JPA
- 🐘 PostgreSQL
- 🔧 Maven
- 🧪 Spring Boot Starter Test
- 📦 Hibernate/JPA

## 📋 Descripción

El objetivo del proyecto es construir una API REST sencilla para consultar y administrar información relacionada con películas.

Actualmente la aplicación permite:

- Consultar todas las películas.
- Registrar nuevas películas.
- Actualizar el estado de una película utilizando su título.
- Consultar los géneros disponibles.
- Consultar una vista con información completa de las películas.

## 🏗️ Estructura del proyecto

```text
ProyectoDesarrolloBackend/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── pelicula/
│   │   │           └── pelicula/
│   │   │               ├── controller/
│   │   │               │   ├── GeneroController.java
│   │   │               │   └── PeliculaController.java
│   │   │               ├── model/
│   │   │               │   ├── Genero.java
│   │   │               │   ├── Pelicula.java
│   │   │               │   └── PeliculaCompletavw.java
│   │   │               ├── repository/
│   │   │               │   ├── GeneroRepository.java
│   │   │               │   ├── PeliculaRepository.java
│   │   │               │   └── PeliculaCompletaRepository.java
│   │   │               └── PeliculaApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback-spring.xml
│   └── test/
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## 🔌 Endpoints

### 🎬 Películas

#### Obtener todas las películas

```http
GET /api/peliculas
```

Devuelve la lista completa de películas almacenadas.

#### Registrar una película

```http
POST /api/peliculas
```

Ejemplo de solicitud:

```json
{
  "titulo": "Interestelar",
  "anoLanzamiento": 2014
}
```

> Los campos exactos disponibles dependen de la estructura actual de la entidad `Pelicula`.

#### Actualizar el estado de una película

```http
PATCH /api/peliculas/{titulo}/estado
```

Ejemplo:

```http
PATCH /api/peliculas/Interestelar/estado
```

Cuerpo de la solicitud:

```json
{
  "estado": "VISTA"
}
```

#### Obtener películas completas

```http
GET /api/peliculas/completas
```

Este endpoint consulta la información mediante el repositorio asociado a la vista `vw_peliculas_completas`.

---

### 🎭 Géneros

#### Obtener géneros

```http
GET /api/generos
```

Devuelve los géneros disponibles en la base de datos.

## 🗄️ Base de datos

El proyecto utiliza **PostgreSQL** como sistema gestor de base de datos.

La comunicación entre la aplicación y PostgreSQL se realiza mediante:

- Spring Data JPA
- Hibernate
- Driver oficial de PostgreSQL

La configuración de conexión se encuentra en:

```text
src/main/resources/application.properties
```

### ⚠️ Configuración

Antes de ejecutar el proyecto, se debe configurar correctamente la conexión a PostgreSQL.

Ejemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_datos
spring.datasource.username=usuario
spring.datasource.password=contraseña
```

Los valores deben adaptarse al entorno local.

## ▶️ Ejecución del proyecto

### Requisitos

Antes de ejecutar la aplicación se recomienda tener instalado:

- Java 17 o superior.
- PostgreSQL.
- Maven (opcional, ya que el proyecto incluye Maven Wrapper).

### Ejecutar con Maven Wrapper en Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### Ejecutar con Maven

```bash
mvn spring-boot:run
```

Una vez iniciada la aplicación, la API estará disponible normalmente en:

```text
http://localhost:8080
```

## 🧪 Pruebas de la API

Los endpoints pueden probarse utilizando herramientas como:

- Postman
- Insomnia
- Thunder Client
- cURL

Ejemplo:

```bash
curl http://localhost:8080/api/peliculas
```

## 📁 Arquitectura

El proyecto utiliza una estructura sencilla basada en separación por responsabilidades:

### Controller

Contiene los endpoints REST y recibe las solicitudes HTTP.

Ejemplos:

- `PeliculaController`
- `GeneroController`

### Model

Representa las entidades y modelos utilizados por la aplicación.

Ejemplos:

- `Pelicula`
- `Genero`
- `PeliculaCompletavw`

### Repository

Contiene las interfaces utilizadas para acceder a los datos mediante Spring Data JPA.

Ejemplos:

- `PeliculaRepository`
- `GeneroRepository`
- `PeliculaCompletaRepository`

## 📌 Estado del proyecto

Proyecto académico/práctico en desarrollo.

La implementación actual está enfocada en practicar:

- Java
- Spring Boot
- APIs REST
- JPA/Hibernate
- PostgreSQL
- Arquitectura básica backend
- Consultas mediante repositorios
- Uso de vistas de base de datos

## 👨‍💻 Autor

**Kevin Osorio**

GitHub: [KevinOsorioDEV](https://github.com/KevinOsorioDEV)

Repositorio: [ProyectoDesarrolloBackend](https://github.com/KevinOsorioDEV/ProyectoDesarrolloBackend)

---

⭐ Proyecto desarrollado con fines de aprendizaje y práctica de desarrollo backend.
