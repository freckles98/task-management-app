package com.chelseavancoller.backend.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Entity // used to define a class that will be peristed to a database table.
// Use the annotation @Table to change the name of the table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // For these fields you can specifiy column names, constraints, etc with
    // @Column. But happy to leave as is
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private boolean completed;
    @FutureOrPresent(message = "Due date must be today or in the future")
    private LocalDate dueDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // Creates a foreign key column
    private User user;
    // Other potential fields: priority, tags, status

    // JPA only - apparently needed as it uses reflection.
    // Hibernates relfection engine allows it to access private constructors
    // Very cool! Make it private so devs aren't lazy!
    private Task() {
    }

    public Task(Long id, String title, String description, boolean completed, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    // Apparently it's typically unwise to have setters, but I think we'll need it
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
