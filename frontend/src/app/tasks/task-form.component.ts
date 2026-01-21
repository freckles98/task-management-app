import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-form.component.html',
  styleUrl: './task-form.component.css'
})
export class TaskFormComponent {
  private http = inject(HttpClient);

  // Matches your interface (excluding id/completed which Backend handles)
  newTask = {
    title: '',
    description: '',
    dueDate: ''
  };

  addTask() {
    const url = 'http://localhost:9090/api/tasks';
    
    // Remember to use the current password from your logs!
    const authHeader = 'Basic ' + btoa('user:YOUR_GENERATED_PASSWORD_HERE');
    const headers = new HttpHeaders({ 'Authorization': authHeader });

    this.http.post(url, this.newTask, { headers }).subscribe({
      next: (response) => {
        console.log('Task Created!', response);
        alert('Task added successfully!');
        // Reset form
        this.newTask = { title: '', description: '', dueDate: '' };
      },
      error: (err) => {
        console.error('Error creating task:', err);
        alert('Failed to create task.');
      }
    });
  }
}