#  Quiz App - Microservices Architecture

This is a **Quiz Application** built using a **microservices architecture** with Spring Boot. The system is broken down into independent services that handle different responsibilities such as quiz management, question handling, and API routing. It also includes service discovery using Eureka.

---

## 🏗️ Project Structure
QuizAppMicroservices/ <br>
├── api-gateway/ # Handles routing, filtering, and authentication <br>
├── question-service/ # Manages quiz questions and interacts with DB <br>
├── quiz-service/ # Handles quiz creation and mapping with questions <br>
├── service-registry/ # Eureka server for service discovery <br>
## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- RESTful APIs
- Maven
- MySQL or H2 (for dev/testing)
- Postman (for API testing)
- Lombok (to reduce boilerplate)
- Swagger (optional for API docs)

---

##  Service Overview

###  `service-registry`
- Implements Eureka Server
- All microservices register themselves here
- Enables dynamic discovery and load balancing

###  `api-gateway`
- Acts as the single entry point for all clients
- Handles routing to backend services
- Can be extended to include JWT Auth, rate limiting, logging, etc.

###  `question-service`
- CRUD operations for quiz questions
- Exposes endpoints:
    - `GET /questions`
    - `GET /questions/quiz/{quizId}`
    - `POST /questions`
- Interacts with a relational DB (MySQL or H2)

###  `quiz-service`
- Handles quiz creation and management
- Calls `question-service` to fetch quiz questions
- Exposes endpoints:
    - `GET /quiz`
    - `GET /quiz/full/{quizId}` → returns quiz + its questions
    - `POST /quiz`

---

##  How to Run the Project

### Step 1: Start the Eureka Server
```bash
cd eureka-service
./mvnw spring-boot:run
```
Step 2: Start the API Gateway
```bash
cd api-gateway
./mvnw spring-boot:run
```
Step 3: Start the Question Service
```bash
cd question-service
./mvnw spring-boot:run
```
Step 4: Start the Quiz Service
```bash
cd quiz-service
./mvnw spring-boot:run
```
### Example API Calls (Use Postman or Swagger)
GET /quiz-service/quiz → Fetch all quizzes

GET /quiz-service/quiz/full/{quizId} → Fetch quiz with its questions

POST /question-service/questions → Add a new question

GET /question-service/questions/quiz/{quizId} → Fetch questions by quiz

### Possible Enhancements
 Add JWT-based authentication and role-based access

 Dockerize all services for containerized deployment

 Add centralized Config Server for dynamic configs

 Enable Resilience4J Circuit Breaker and Retry

 Use Swagger UI for API documentation

### Learning Outcomes:
Microservices communication via REST

API Gateway and service registry setup

Service decoupling and modularization

Basic service orchestration using Eureka

Spring Boot layered architecture

### Contributing
Feel free to fork this repo and contribute via PRs.
