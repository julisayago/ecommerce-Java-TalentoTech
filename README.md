# 🛒 Ecommerce API - Proyecto Backend con Spring Boot

Este proyecto es una API REST desarrollada en **Java 21** con **Spring Boot**, pensada para gestionar productos dentro de una tienda online. Fue construido como parte del programa **TalentoTech**, con enfoque en buenas prácticas, uso de DTOs y separación de responsabilidades.

---

## 🧠 ¿Qué hace esta API?

- 📦 Crea nuevos productos.
- 📋 Lista todos los productos almacenados.
- 🔍 Busca productos por ID.
- ✏️ Actualiza productos existentes.
- 🗑️ Elimina productos de la base de datos.

---

## 📋 Endpoints

- **POST** `/productos` – Crear un nuevo producto.
- **GET** `/productos` – Listar todos los productos.
- **GET** `/productos/{id}` – Obtener un producto por ID.
- **PUT** `/productos/{id}` – Actualizar un producto existente.
- **DELETE** `/productos/{id}` – Eliminar un producto por ID.

---

## 🛠️ Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- REST API
- DTO Pattern
- H2 (base de datos en memoria)

