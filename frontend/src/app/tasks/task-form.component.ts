import { Component, inject, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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

    if (!this.newTask.title || !this.newTask.dueDate) {
    alert("Please fill in all fields!");
    return;
    }

    const url = 'http://localhost:9090/api/tasks/create';
  
    this.http.post(url, this.newTask).subscribe({
      next: () => {
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
