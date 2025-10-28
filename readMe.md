# 🧩 Spring Boot CRUD Application

A simple **CRUD (Create, Read, Update, Delete)** application built with **Spring Boot**, **Spring Data JPA**, and **Thymeleaf (or REST APIs)**.  
This project demonstrates basic operations on a database entity using Spring Boot and follows a layered architecture (Controller → Service → Repository).

---

## 🚀 Features

- Create a new record
- Read all records or by ID
- Update existing record
- Delete record
- Validation and exception handling
- Uses **Spring Boot**, **Spring Data JPA**, and **H2/MySQL** database
- Easy to run and extend

---

## 🛠️ Technologies Used

| Layer                | Technology                                                  |
| -------------------- | ----------------------------------------------------------- |
| Backend              | Spring Boot 3+, Spring MVC, Spring Data JPA,Spring Security |
| View (if applicable) | Thymeleaf                                                   |
| Database             | MySQL                                                       |
| Build Tool           | Maven                                                       |
| Language             | Java 17+                                                    |

---

## 📂 Project Structure

crud-springboot/
├── src/
│ ├── main/
│ │ ├── java/com/example/crud/
│ │ │ ├── controller/ # REST or web controllers
│ │ │ ├── service/ # Business logic
│ │ │ ├── repository/ # JPA repositories
│ │ │ ├── model/ # Entity classes
│ │ │ └── CrudApplication.java
│ │ └── resources/
│ │ ├── templates/ # Thymeleaf HTML files (if used)
│ │ ├── static/ # CSS, JS, images
│ │ └── application.properties
│ └── test/ # Unit and integration tests
└── pom.xml
