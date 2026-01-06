🍽️ El Buen Sabor - Sistema de Gestión de Reservas
Este proyecto es una aplicación Spring Boot multi-módulo diseñada para gestionar las reservas de un restaurante, permitiendo a los clientes reservar mesas en tiempo real y a los administradores gestionar la disponibilidad y estados.

🏗️ Arquitectura del Proyecto
El sistema utiliza una Arquitectura Limpia (Clean Architecture) dividida en módulos para separar responsabilidades y asegurar el desacoplamiento:

common: Contiene el dominio (Entities), Repositorios (JPA) y servicios compartidos como el de mensajería .

cliente: Módulo que aloja el formulario de reserva y la lógica para el comensal.

administrador: Panel de control para Luis Martínez, permitiendo la gestión de estados y visualización de reservas.

🛠️ Tecnologías y Prerrequisitos
Java 21 (Uso de Records para DTOs).

Maven (Gestor de dependencias).

PostgreSQL (Base de datos relacional).

Thymeleaf & Bootstrap 5 (Vistas responsivas).

Mailtrap (Servidor SMTP de pruebas ).

🚀 Instalación y Ejecución
1. Clonar el repositorio
Bash


1. Configuración de Base de Datos
Crea una base de datos en PostgreSQL llamada reservas_db. Luego, configura tus credenciales en el archivo application.properties del módulo que vayas a ejecutar (usualmente cliente):

Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/reservas_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# Credenciales de Mailtrap 
spring.mail.username=tu_user_mailtrap
spring.mail.password=tu_pass_mailtrap


2. Compilación e Instalación
Debes instalar los módulos en el repositorio local de Maven empezando por la raíz:

Bash
mvn clean install -DskipTests


4. Ejecutar la aplicación
Para iniciar el sistema completo (usando el módulo cliente como host):

Bash

mvn spring-boot:run -pl cliente

📱 Acceso desde Dispositivos Móviles 
Para acceder desde tu celular:

Asegúrate de estar en la misma red Wi-Fi.

Obtén tu IP local (ipconfig).

Accede a: http://tu_ip:8080/reserva

Notas de Desarrollo
import.sql: Al iniciar, el sistema precarga las mesas configuradas en este archivo.

