🍽 EaseDine – Food Delivery Backend API

EaseDine is a RESTful food delivery backend application built using Spring Boot, designed to manage food orders, restaurants, user authentication, reviews, and more. It includes features like JWT-based authentication, role-based access control, review and rating systems and secure user registration/login. The API is well-structured with clean separation of concerns, DTO usage, exception handling, and Swagger documentation for easy testing.

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Lombok
- JPA & Hibernate
- PostgreSQL 
- Swagger (Springdoc OpenAPI)

---

## ✅ Features

- User registration with secure password hashing
- Login functionality with JWT token generation
- Role-based access: `ROLE_USER`, `ROLE_ADMIN`
- Swagger UI authorization support
- JWT filter for protecting endpoints
- UUID generation for unique user IDs

---

## 🧱 Project Structure

com.easedine.easedine
│

├── auth    // Authentication and JWT management

├── config       // Security configuration, Swagger, JWT filter, Cloudinary setup

├── controller   // API endpoints for food items, orders, restaurants, users, etc.

├── dto          // Data Transfer Objects for request and response handling

├── exceptions   // Custom exception classes for error handling

├── model        // Entity and enum classes (User, Order, FoodItem, etc.)

├── repository   // Spring Data JPA repositories

└── service      // Business logic and service layer implementation

---

🔑 Using Swagger UI with JWT

- First, hit /auth/login and copy the JWT token.

- Go to Swagger UI → Click Authorize.

- Paste token in this format:

- Bearer <your_token_here>

Now you can access protected endpoints based on your role.

---

🚀 How to Run

- Clone the project:

       git clone https://github.com/your-username/easedine-auth
       cd easedine-auth
  
- Set your DB credentials in application.properties.
- Run the application:
  
      ./mvnw spring-boot:run

- Open Swagger UI:

    http://localhost:8080/swagger-ui/index.html
  
  ---

✨ Future Scope

- Email verification during registration

- Token refresh functionality

- Admin dashboard for managing users

- OAuth2 / Google Login

---

👨‍💻 Author

- Developed with ❤️ by Arnesh R
- Contributions are welcome!



