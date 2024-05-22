import { Component } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  imports: [RouterOutlet, FormsModule]
})
export class LoginComponent {
  errorMessage: string = '';
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login(username: string, password: string) {
    this.authService.login(username, password).subscribe(
      response => {
        if (response.message === 'Ingreso con éxito') {
          this.router.navigate(['/dashboard']); // Redirigir al dashboard o a la página principal
        } else {
          this.errorMessage = 'Ingreso fallido';
        }
      },
      error => {
        this.errorMessage = 'Error en el servidor';
      }
    );
  }
}

