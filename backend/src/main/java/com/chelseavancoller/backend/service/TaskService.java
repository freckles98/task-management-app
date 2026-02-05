package com.chelseavancoller.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chelseavancoller.backend.models.Task;
import com.chelseavancoller.backend.models.User;
import com.chelseavancoller.backend.repository.TaskRepository;

@Service
public class TaskService {

    TaskRepository taskRepository;

    // Constructor Injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByUser(User user) {
        // The Service calls the Repository
        return taskRepository.findByUser(user);
    }

    public Task createTask(Task task) {
        if (task.isCompleted() == false) {
            task.setCompleted(false);
        }

        return taskRepository.save(task);
    }

}
