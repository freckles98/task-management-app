package com.example.backend.task.service;

import com.example.backend.task.model.CreateTaskRequest;
import com.example.backend.task.model.Task;
import com.example.backend.task.model.UpdateTaskRequest;

import java.util.List;

public interface TaskService {
    Task createTask(CreateTaskRequest request, Long userId);

    List<Task> getTasks(Long userId);

    Task updateTask(Long taskId, UpdateTaskRequest request, Long userId);

    void deleteTask(Long taskId, Long userId);
}
