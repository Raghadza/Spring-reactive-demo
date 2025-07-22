# Spring Reactive Demo

This repository is a **Spring Boot** application demonstrating **Reactive Programming** with **Spring WebFlux**. The project showcases how to build a simple reactive REST API for managing **students** with basic operations like **create**, **read**, **update**, and **delete** (CRUD).

It leverages **Project Reactor** for handling asynchronous, non-blocking data streams, and **Spring Data Reactive** for integrating with PostgreSQL in a reactive manner.

---

## Technologies Used

- **Spring Boot** (2.x)
- **Spring WebFlux** (for reactive programming)
- **Spring Data R2DBC** (for reactive data access with PostgreSQL)
- **Project Reactor** (for reactive streams)
- **PostgreSQL** (for data persistence)
- **Lombok** (to reduce boilerplate code)
- **R2DBC** (Reactive Relational Database Connectivity)

---

## Features

- **CRUD Operations for Students**:
  - Create a new student.
  - Retrieve all students.
  - Retrieve a specific student by ID.
  - Update student details.
  - Delete a student.

- **Reactive Programming**:
  - Non-blocking I/O using **Reactive Streams**.
  - Use of `Mono` and `Flux` for single and multiple data items.
  
- **Database Interaction with PostgreSQL**:
  - Integration with **PostgreSQL** using **R2DBC** for reactive database interactions.

---

## Getting Started

Follow these steps to run the project locally.

### Prerequisites

- **Java 17+** (JDK)
- **Maven** (for building the project)
- **PostgreSQL** (for data persistence)
- An IDE like **IntelliJ IDEA** or **Eclipse**.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Raghadza/Spring-reactive-demo.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Spring-reactive-demo
   ```

3. Build the project using:

   ```bash
   mvn clean install
   ```

4. Start the application:

   ```bash
   mvn spring-boot:run
   ```

The application should now be running at `http://localhost:8080`.

---
## Running the Application

After running the application with `mvn spring-boot:run`, you can test the API endpoints using **Postman**, **cURL**, or any HTTP client.

Example using cURL to get all students:

```bash
curl -X GET http://localhost:8080/students
```
---

## API Endpoints

### 1. Get All Students

* **Endpoint**: `GET /students`
* **Response**: List of all students.

  Example response:

  ```json
  [
    { "id": "1", "firstName": "Alice", "lastName": "White", "age": 20 },
    { "id": "2", "firstName": "Bob", "lastName": "Johnson", "age": 22 },
    { "id": "3", "name": "Charlie", "lastName": "Smith" "age": 23 }
  ]
  ```

### 2. Get Student by ID

* **Endpoint**: `GET /students/{id}`
* **Response**: A single student object.

  Example response for `GET /students/1`:

  ```json
  { "id": "1", "firstName": "Alice", "lastName": "White", "age": 20 }
  ```

### 3. Add a New Student

* **Endpoint**: `POST /students`
* **Body**:

  ```json
  {
    "firstName": "Anne",
    "lastName": "Williams",
    "age": 21
  }
  ```
* **Response**: The created student object with an assigned `id`.

### 4. Update a Student

* **Endpoint**: `PUT /students/1`
* **Body**:

  ```json
  {
    "id": "1",
    "firstName": "Alice",
    "lastName": "White",
    "age": 24
  }
  ```
* **Response**: Updated student object.

### 5. Delete a Student

* **Endpoint**: `DELETE /students/1`
* **Response**: Status code 200 (ok) No content on successful deletion.

---

## Contact

For any questions or feedback, please contact at [raghadzamil11@gmail.com].
