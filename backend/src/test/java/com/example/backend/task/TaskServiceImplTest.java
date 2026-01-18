package com.example.backend.task;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.backend.task.service.TaskServiceImpl;
import com.example.backend.auth.model.User;
import com.example.backend.auth.repository.UserRepository;
import com.example.backend.task.model.CreateTaskRequest;
import com.example.backend.task.model.Task;
import com.example.backend.task.model.TaskResponse;
import com.example.backend.task.repository.TaskRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        // given
        CreateTaskRequest request = new CreateTaskRequest(
                "Test Task",
                "Description",
                "High",
                LocalDate.now().plusDays(1));

        User user = new User("testuser", "test@example.com", "password");
        when(userRepository.getReferenceById(1L)).thenReturn(user);

        Task savedTask = new Task(
                "Test Task",
                "Description",
                LocalDate.now().plusDays(1),
                user,
                "High");
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        // when
        Task result = taskService.createTask(request, 1L);

        // then
        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());

        verify(userRepository).getReferenceById(1L);
        verify(taskRepository).save(any(Task.class));
    }
}
