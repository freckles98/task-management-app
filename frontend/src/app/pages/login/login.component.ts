import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Needed for [(ngModel)]
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
  credentials = {
    username: '',
    password: ''
  };

  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.credentials).subscribe({
      next: (res) => {
        // 1. Login Successful
        console.log('Login success:', res);
        // 2. Navigate to the Task List
        this.router.navigate(['/']); 
      },
      error: (err) => {
        // 3. Handle Failure
        console.error('Login failed', err);
        this.errorMessage = 'Invalid username or password';
      }
    });
  }
}