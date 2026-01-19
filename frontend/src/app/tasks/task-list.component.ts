import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-list.component.html'
})
export class TaskListComponent {
  tasks = [
    { title: 'Finish backend', priority: 'HIGH' },
    { title: 'Write tests', priority: 'MEDIUM' }
  ];
}
