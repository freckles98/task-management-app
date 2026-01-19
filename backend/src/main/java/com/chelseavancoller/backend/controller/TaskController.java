package com.chelseavancoller.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {
    @RequestMapping("/tasks")
    public List<Task> getAllTasks() {
        // Implementation here
    }

}
