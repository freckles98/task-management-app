package com.example.backend.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.auth.model.User;
import com.example.backend.auth.repository.UserRepository;
import com.example.backend.task.model.CreateTaskRequest;
import com.example.backend.task.model.Task;
import com.example.backend.task.model.UpdateTaskRequest;
import com.example.backend.task.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(CreateTaskRequest taskRequest, Long userId) {

        User user = userRepository.getReferenceById(userId);

        Task task = new Task(
                taskRequest.getTitle(),
                taskRequest.getDescription(),
                taskRequest.getDueDate(), user,
                taskRequest.getPriority());

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, UpdateTaskRequest taskRequest, Long userId) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        // Update fields from request
        existingTask.setTitle(taskRequest.getTitle());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setPriority(taskRequest.getPriority());
        existingTask.setDueDate(taskRequest.getDueDate());
        taskRepository.save(existingTask);
        return existingTask;
    }

    @Override
    public void deleteTask(Long id, Long userId) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasks(Long userId) {
        return taskRepository.findByUserId(userId);
    }

}