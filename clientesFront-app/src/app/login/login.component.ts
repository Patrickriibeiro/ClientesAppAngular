import { Component
} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: String;
  password: string;
  loginError: boolean;

  constructor() { }

  onSubmit(){
    console.log(`User:  ${this.username}, Pass: ${this.password}`);
  }

}
