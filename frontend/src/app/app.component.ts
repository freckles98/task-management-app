import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

import { TaskFormComponent } from './tasks/task-form.component';
import { TaskListComponent } from './tasks/task-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule, 
    RouterOutlet,
    TaskFormComponent,
    TaskListComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  isModalOpen = false;

  openModal() {
    console.log('Button clicked');
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }
}
