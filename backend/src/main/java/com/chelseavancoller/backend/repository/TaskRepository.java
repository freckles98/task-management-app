package com.chelseavancoller.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chelseavancoller.backend.models.Task;
import com.chelseavancoller.backend.models.User;

// One of the most magical elements I have discoved about Spring Boot
// By extending JpaRepository you get a ton of functionality for free
// AND you can define custom query methods by following naming conventions
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitleContaining(String title);

    List<Task> findByUser(User user);

}