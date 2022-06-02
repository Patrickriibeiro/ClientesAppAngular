import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Funcionarios } from './funcionarios/funcionarios';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {

  apiUrl: string = environment.apiURLBase + '/api/funcionarios';

  constructor(private http: HttpClient) {

   }

  salvar(funcionarios: Funcionarios) : Observable<any> {
    return this.http.post<Funcionarios>(`${this.apiUrl}`, funcionarios)
  }

  

  getFuncionario() : Funcionarios {
    let funcionarios : Funcionarios = new Funcionarios();
    funcionarios.nome = "teste";
    funcionarios.cpf = "12345";
    return funcionarios;
  }
}
