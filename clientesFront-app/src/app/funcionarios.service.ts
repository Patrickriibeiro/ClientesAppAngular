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

  salvar(funcionarios: Funcionarios) : Observable<Funcionarios> {
    return this.http.post<Funcionarios>(`${this.apiUrl}`, funcionarios)
  }

  getFuncionarios() : Observable<Funcionarios[]>{
    return this.http.get<Funcionarios[]>(this.apiUrl)
  }

  getFuncionarioById(id: number) : Observable<Funcionarios>{
    return this.http.get<Funcionarios>(`${this.apiUrl}/${id}`)
  }
}
