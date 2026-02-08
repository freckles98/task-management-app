import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router'; 
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink], // Add RouterLink for the "Back to Login" button
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'] // You can reuse login.component.css if you want!
})
export class RegisterComponent {
  
  credentials = {
    username: '',
    password: ''
  };

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.register(this.credentials).subscribe({
      next: (res) => {
        // Success! You are registered and logged in.
        // Navigate straight to tasks
        this.router.navigate(['/tasks']);
      },
      error: (err) => {
        alert("Registration failed! Try a different username.");
      }
    });
  }
}