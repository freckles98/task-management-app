import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { TaskDashboardComponent } from './pages/task-dashboard/task-dashboard.component'; // Import the new page

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'tasks', component: TaskDashboardComponent }, // Point to the new Component
  { path: '', redirectTo: '/login', pathMatch: 'full' } // Default to Login
];