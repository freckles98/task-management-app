package com.example.backend.task.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.backend.task.model.CreateTaskRequest;
import com.example.backend.task.model.Task;
import com.example.backend.task.model.TaskResponse;
import com.example.backend.task.model.UpdateTaskRequest;
import com.example.backend.task.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // TEMP: stubbed userId due to time constraints
    private static final Long USER_ID = 1L;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(@RequestBody CreateTaskRequest taskRequest) {

        Task task = taskService.createTask(taskRequest, USER_ID);
        return new TaskResponse(task);
    }

    @GetMapping
    public List<TaskResponse> getTasks() {

        return taskService.getTasks(USER_ID)
                .stream()
                .map(task -> new TaskResponse(task))
                .toList();
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id,
            @RequestBody UpdateTaskRequest taskRequest) {

        Task task = taskService.updateTask(id, taskRequest, USER_ID);
        return new TaskResponse(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id, USER_ID);
    }
}
