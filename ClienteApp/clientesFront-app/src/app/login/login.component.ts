import { Component
} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: String;
  password: string;
  loginError: boolean;
  cadastrando: boolean;

  constructor( private router: Router) { }

  onSubmit(){
    this.router.navigate(['/home'])
    console.log(`User:  ${this.username}, Pass: ${this.password}`);
  }

  preparaCadastrar(event: any){
    event.preventDefault()
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }

}
