import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { TaskFormComponent } from './tasks/task-form.component';
import { TaskListComponent } from './tasks/task-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    TaskFormComponent,
    TaskListComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
