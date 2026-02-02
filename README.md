# task-management-app

## Overview

A simple task management application consisting of a Spring Boot backend and Angular frontend.

## Task Model

- **Title** (String)
- **Due Date** (Date)
- **Description** (String)
- **User ID** (String)

## API Endpoints

| Method | Endpoint          | Description                               |
| ------ | ----------------- | ----------------------------------------- |
| POST   | `/api/tasks`      | Create a new task                         |
| GET    | `/api/tasks`      | Retrieve all tasks for authenticated user |
| PUT    | `/api/tasks/{id}` | Update an existing task                   |
| DELETE | `/api/tasks/{id}` | Delete a task                             |

## Basic API Flow

1. **Create** - POST a new task with title, due date, and description
2. **Retrieve** - GET all tasks associated with the authenticated user
3. **Update** - PUT changes to an existing task
4. **Delete** - DELETE a task by ID
