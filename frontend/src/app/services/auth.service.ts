import { Injectable, inject, PLATFORM_ID } from '@angular/core'; // Import PLATFORM_ID
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { isPlatformBrowser } from '@angular/common'; // Import this helper

@Injectable({ providedIn: 'root' })
export class AuthService {
  private http = inject(HttpClient);
  // Inject the platform ID so we know where we are running
  private platformId = inject(PLATFORM_ID); 
  
  private apiUrl = 'http://localhost:9090/api/auth';

  login(credentials: any) {
    return this.http.post<any>(`${this.apiUrl}/authenticate`, credentials).pipe(
      tap(response => {
        // Only save to localStorage if we are in the browser
        if (isPlatformBrowser(this.platformId)) {
          localStorage.setItem('token', response.token);
        }
      })
    );
  }

  getToken(): string | null {
    // Check if we are in the browser
    if (isPlatformBrowser(this.platformId)) {
      return localStorage.getItem('token');
    }
    // If on the server, return null (no token exists on the server)
    return null;
  }

  logout() {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem('token');
    }
  }
}