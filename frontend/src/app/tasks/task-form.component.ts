import { Component, inject, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {
  private http = inject(HttpClient);

  @Output() taskCreated = new EventEmitter<void>();

  newTask: { title: string; description: string; dueDate: string | null } = {
    title: '',
    description: '',
    dueDate: null
  };

  addTask() {
    const url = 'http://localhost:9090/api/tasks/create';
    const authHeader = 'Basic ' + btoa('user:password');
    const headers = new HttpHeaders({ Authorization: authHeader });

    this.http.post(url, this.newTask, { headers }).subscribe({
      next: () => {
        alert('Task added successfully!');
        this.newTask = { title: '', description: '', dueDate: null };
        this.taskCreated.emit(); // close modal
      },
      error: (err) => {
        console.error('Error creating task:', err);
        alert('Failed to create task.');
      }
    });
  }
}
