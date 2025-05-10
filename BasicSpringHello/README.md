# 📘 BasicSpringHello (with extra /users endpoint)

This project is a simple Spring Boot application created as part  
of a Java developer training course.

📌 It demonstrates:
- Basic REST API functionality  
- Integration with a MySQL database  
- Usage of Spring Boot, Spring Data JPA, Docker, and Postman

## 🚀 How to Run the Project

This project is designed to run using **Docker Compose**.  
To get started, follow these steps:

1. Make sure Docker and Docker Compose are installed.
2. Create a `.env` file in the project root with the following content (adjust values as needed):

   ```env
   MYSQL_DATABASE=basicdb
   MYSQL_USER=myuser
   MYSQL_PASSWORD=mypassword
   MYSQL_ROOT_PASSWORD=myrootpassword
   ```
3. Build and start the containers:
   docker compose up --build

4. Access the application at:
   http://localhost:8080/users

## 📡 Available API Endpoints

These endpoints are available once the application is running:

| Method | Endpoint        | Description                  |
|--------|-----------------|------------------------------|
| GET    | `/users`        | Retrieve all users           |
| POST   | `/users`        | Create a new user            |

## 🧪 Testing the API

You can test the API endpoints using tools like **Postman** or any other REST client.

To create a user via `POST`, you can send a JSON body like this:

```json
{
  "name": "Alice",
  "email": "alice@example.com"
}
```

## 🛠️ Technologies Used

This project is built using the following technologies:

- **Java 21**
- **Spring Boot** (REST controller and dependency injection)
- **Spring Data JPA** (database interaction)
- **MySQL** (relational database)
- **Docker & Docker Compose** (containerized development)
- **Postman** (manual API testing)

![License: GPL-3.0](https://img.shields.io/badge/License-GPL_3.0-blue.svg)

## 📝 License

This project is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html).
