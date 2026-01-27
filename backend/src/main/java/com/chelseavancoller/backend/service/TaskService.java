package com.chelseavancoller.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chelseavancoller.backend.models.Task;
import com.chelseavancoller.backend.repository.TaskRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {

    TaskRepository taskRepository;

    // Constructor Injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        // Dummy data
        return List.of(
                new Task(1L, "Task 1", "Description 1", false, null),
                new Task(2L, "Task 2", "Description 2", true, null));
    }

    public Task createTask(Task task) {
        if (task.isCompleted() == false) {
            task.setCompleted(false);
        }

        return taskRepository.save(task);
    }

}
