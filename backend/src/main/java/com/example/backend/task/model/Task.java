package com.example.backend.task.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.example.backend.auth.model.User;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private String priority;

    protected Task() {
        // JPA only
    }

    public Task(String title, String description, LocalDate dueDate, User user, String priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.user = user;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public User getUser() {
        return user;
    }

    public String getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Should not do this - shortcut for testing purposes only
    public void setId(Long id) {
        this.id = id;
    }

    public void update(String title, String description, String priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

}
