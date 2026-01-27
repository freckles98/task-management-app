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
    newTask: { title: string; description: string; dueDate: string | null } = {
    title: '',
    description: '',
    dueDate: null // <--- Use null, not ''
    };

  addTask() {
    const url = 'http://localhost:9090/api/tasks/create';
    
    // Remember to use the current password from your logs!
    const authHeader = 'Basic ' + btoa('user:password');
    const headers = new HttpHeaders({ 'Authorization': authHeader });
    const payload : any = { ...this.newTask };

    this.http.post(url, payload, { headers }).subscribe({
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