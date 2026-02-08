package com.chelseavancoller.backend.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chelseavancoller.backend.models.Task;
import com.chelseavancoller.backend.models.User;
import com.chelseavancoller.backend.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/retrieve")
    public List<Task> getAllTasks(@AuthenticationPrincipal User user) {
        // "user" is automatically injected by Spring from the JWT token!
        return taskService.getTasksByUser(user);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task, @AuthenticationPrincipal User user) {

        task.setUser(user); // Stamp the task with the user's ID
        return taskService.createTask(task);
    }

}
