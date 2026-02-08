import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { AuthService } from '../services/auth.service';
interface Task {
  id: number;
  title: string;
  description: string;
  completed: boolean;
  dueDate: string;
}
@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent implements OnInit {
  // Inject the HTTP Client
  private http = inject(HttpClient);
  
  tasks: Task[] = [];


  ngOnInit() {
    this.fetchTasks();
    this.loadTasks();
  }

  fetchTasks() {
    // Our lovely backend
    const url = 'http://localhost:9090/api/tasks/retrieve';

  

    this.http.get<Task[]>(url).subscribe({
      next: (data) => {
        this.tasks = data;
        console.log('Tasks loaded:', data);
      },
      error: (err) => {
        console.error('Failed to fetch tasks', err);
      }
    });
  }
  loadTasks() {
  const authHeader = 'Basic ' + btoa('user:password'); // or JWT token
  const headers = new HttpHeaders({ Authorization: authHeader });

  this.http.get<any[]>('http://localhost:9090/api/tasks/retrieve', { headers })
    .subscribe(data => this.tasks = data);
  }
}
