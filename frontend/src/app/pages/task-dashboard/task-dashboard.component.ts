import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterOutlet } from '@angular/router';


import { ViewChild } from '@angular/core';
import { TaskListComponent } from '../../tasks/task-list.component';
import { TaskFormComponent } from '../../tasks/task-form.component';

@Component({
  selector: 'app-task-dashboard',
  standalone: true,
  // Import the smaller components you built earlier
   imports: [
    CommonModule, 
    RouterOutlet,
    TaskFormComponent,
    TaskListComponent
  ],
  templateUrl: './task-dashboard.component.html',
  styleUrls: ['./task-dashboard.component.css']
})

export class TaskDashboardComponent implements OnInit {
    ngOnInit(): void {
        throw new Error('Method not implemented.');
    }
     isModalOpen = false;
      @ViewChild(TaskListComponent) taskList!: TaskListComponent;
   
     openModal() {
       console.log('Button clicked');
       this.isModalOpen = true;
     }
   
     closeModal() {
       this.isModalOpen = false;
     }
       handleTaskCreated() {
       this.closeModal();           // close modal
       this.taskList.loadTasks();   // refresh list
     }
}