# 🏋️‍♀️ Fitness Tracker Backend

## Overview

This is the backend server for the Fitness Tracker application. It's built with Spring Boot and provides a robust API for managing user accounts, workouts, and other fitness-related data.

## 🚀 Features

- RESTful API endpoints for CRUD operations on workouts
- User authentication and authorization
- Data persistence with PostgreSQL
- Secure communication with the frontend

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Frontend: [View on Github](https://github.com/1AlexBunea/FitnessTrackerFrontEnd)

## 🔧 Setup and Installation

1. Clone the repository
2. Navigate to the project directory
3. Configure the database connection in `src/main/java/resources/application.properties`:
4. Build the project
5. Run the application:

## API Endpoints

All endpoints start with `http://localhost:{port#}`, where `{port#}` is your configured port number. Default is port 8080.

- `POST {BASE_URL}/add`: Adds a new email and password to the database (user registration)
- `GET {BASE_URL}/login/{email}/{password}`: Attempts to log in to the database with the provided email and password
- `DELETE {BASE_URL}/delete/{email}/{password}`: Deletes the account associated with the provided email and password from the database

Note: Replace `{BASE_URL}` with your actual base URL, and `{email}` and `{password}` with the actual email and password when making requests.

## Database Schema

The database likely includes a `users` table that stores:
- Email
- Password (should be securely hashed)
- ListItem => Stores all data regarding a user's workout information and dates corresponding to their entries.

## 🔐 Security

Important security considerations:
- Ensure passwords are properly hashed before storing in the database
- Implement proper authentication and authorization checks
- Use HTTPS to encrypt data in transit
- Validate and sanitize all input data

## Contact

For any queries or feedback, please open an issue in this repository.

