package com.example.backend.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task save(Task task);

    List<Task> findByUserId(Long id);

}
