import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet], // IMPORTANT: You must import RouterOutlet
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'task-management-app';
}