### CRUD FÁCIL PARA PRACTICAR

**¿Qué es un CRUD?**
Un CRUD es un acrónimo que significa Crear, Leer, Actualizar y Borrar (Create, Read, Update, Delete). Es una de las operaciones básicas para la gestión de datos en aplicaciones web.

**Introducción**
<br/>
Hoy quiero compartir contigo una manera sencilla y práctica de implementar un CRUD (Crear, Leer, Actualizar, Borrar) utilizando Spring Boot, uno de los frameworks más populares para el desarrollo de aplicaciones Java. En este tutorial, vamos a usar la base de datos H2, una base de datos en memoria que es liviana y fácil de configurar, ideal para proyectos de demostración y pruebas. 

A lo largo de este tutorial, te guiaré paso a paso en la configuración del proyecto, la creación de modelos, repositorios, servicios y controladores, y finalmente, en la configuración de vistas utilizando Thymeleaf. Al final, tendrás una aplicación completa y funcional que te permitirá gestionar una lista de libros. ¡Vamos a ello!

**Tecnologías**
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- H2 Database (o MySQL si prefieres una base de datos persistente)
- Thymeleaf (para las vistas HTML)

### 1. Configurar el proyecto Spring Boot

Lo primero será configurar un proyecto Spring. Usaremos Spring Initializr ([link](https://start.spring.io/)) y añadiremos esta configuración:

- **Project**: Maven Project
- **Language**: Java
- **Spring Boot**: 2.7.x o 3.x.x (la última versión estable)
- **Project Metadata**:
  - Group: `com.example`
  - Artifact: `bookmanager`
  - Name: `BookManager`
- **Dependencias**:
  - Spring Web
  - Spring Data JPA
  - H2 Database (o MySQL si prefieres una base de datos persistente)
  - Thymeleaf (para las vistas HTML)

### 2. Configurar la base de datos

Lo siguiente será apuntar a la base de datos, usando el archivo `application.properties` localizado en `src/main/resources/`. Añade la siguiente configuración:

>spring.datasource.url=jdbc:h2:mem:testdb
>spring.datasource.driverClassName=org.h2.Driver
>spring.datasource.username=sa
>spring.datasource.password=password
>spring.h2.console.enabled=true
>spring.jpa.hibernate.ddl-auto=update`

Esta configuración indica que estamos utilizando una base de datos H2 en memoria (mem:testdb), especifica el controlador de la base de datos, el nombre de usuario y la contraseña. También habilita la consola H2 para facilitar el acceso a la base de datos y configura Hibernate para que actualice automáticamente el esquema de la base de datos según las entidades definidas.

### 3. Crear el modelo

Vamos a `src/main/java/com/example/` y creamos un directorio llamado `bookmanager`. Dentro de este directorio, creamos un paquete llamado `model`. Aquí es donde añadiremos nuestras clases de modelo. Por ejemplo, añadimos la clase `Book.java` que contendrá los atributos y las anotaciones necesarias para mapearla a la base de datos.

### 4. Crear el repositorio

A continuación, salimos del paquete `model` y creamos un nuevo paquete llamado `repository` en `src/main/java/com/example/bookmanager`. Dentro de este paquete, creamos una interfaz que extiende de `JpaRepository` y la llamamos `BookRepository`. Esta interfaz nos proporcionará los métodos CRUD básicos para nuestra entidad `Book`.

### 5. Crear el servicio

Ahora vamos a añadir más funcionalidad creando el servicio. Para ello, creamos un paquete llamado `service` en `src/main/java/com/example/bookmanager`. Dentro de este paquete, añadimos una clase llamada `BookService`. En esta clase, inyectaremos `BookRepository` y utilizaremos sus métodos para implementar las operaciones CRUD. Aquí es donde encapsularemos la lógica de negocio de nuestra aplicación.
### 6. Crear el controlador

Es hora de empezar a ver resultados. Ahora vamos a crear un controlador. Usando el mismo método de siempre, navegamos a `src/main/java/com/example/` y creamos un paquete llamado `controller`. Dentro de este paquete, creamos una clase llamada `BookController`.

En `BookController`, añadiremos nuestras rutas y funciones necesarias para manejar las operaciones CRUD. Este controlador se encargará de mostrar, actualizar, borrar y crear registros de libros. Utilizaremos anotaciones de Spring para mapear las rutas y vincularlas a los métodos correspondientes que gestionan estas operaciones.

### 7. Crear las vistas

Ahora, vamos a trabajar un poco en el front-end. Navegamos a `src/main/resources/templates` y creamos nuestras vistas HTML. En cada archivo HTML, añadimos el atributo `xmlns:th="http://www.thymeleaf.org"` en la etiqueta `<html>`. Esto asegura que Thymeleaf pueda procesar las plantillas correctamente.

En mi caso, he creado los siguientes archivos:
- `index.html`
- `new_book.html`
- `update_book.html`

### 8. Crear la base de datos en DBeaver

A continuación, configuramos la base de datos utilizando DBeaver.

1. **Crear una nueva conexión**:
   - Haz clic en el botón `New Database Connection` o ve a `Database > New Database Connection`.

2. **Seleccionar H2**:
   - En la lista de bases de datos, selecciona `H2 Embedded`. H2 es una base de datos en memoria o archivo que es liviana y rápida.
   - Haz clic en `Next`.

3. **Configurar la conexión**:
   - **Database file**: Aquí puedes especificar el nombre y la ubicación del archivo de la base de datos. Para una base de datos en memoria, puedes usar `mem:testdb`.
     - Por ejemplo, `jdbc:h2:mem:testdb` (esto se alinea con la configuración de Spring Boot que usaremos).
   - **User name**: `sa` (valor predeterminado).
   - **Password**: (dejar en blanco o puedes especificar una contraseña como `password`).

4. **Testear la conexión**:
   - Haz clic en `Test Connection` para asegurarte de que la configuración es correcta.
   - Si todo está bien, deberías ver un mensaje de éxito.
   - Haz clic en `Finish` para crear la conexión.

### Finalizar

Para finalizar, creamos la tabla con los campos que queremos (`id`, `title`, `author`, `isbn`) y lanzamos la aplicación. Luego, accedemos a `localhost:(tu puerto)` en el navegador para disfrutar de nuestro CRUD.

### Conclusión

Hay maneras mejores y peores de hacer un CRUD, así como usar otro tipo de tecnologías, pero lo que he buscado aquí es compartir lo que he ido aprendiendo y mostrar de una manera sencilla cómo hacerlo. 😊
