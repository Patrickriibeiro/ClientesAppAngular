import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { Cargo } from './cargos/cargo';

@Injectable({
  providedIn: 'root'
})
export class CargosService {

  apiUrl: string = environment.apiURLBase + '/api/cargo';

  constructor(private http: HttpClient) { }

  getCargos(): Observable<Cargo[]> {
    return this.http.get<Cargo[]>(this.apiUrl);
  }

  getCargoById(id: number) : Observable<Cargo>{
    return this.http.get<Cargo>(`${this.apiUrl}/${id}`)
  }

  salvar(cargo: Cargo) : Observable<Cargo> {
    return this.http.post<Cargo>(`${this.apiUrl}`, cargo)
  }

  deletarCargoById(id: number) : Observable<any>{
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }

  atualizarCargoById(id: number,cargo: Cargo) : Observable<Cargo>{
    return this.http.put<Cargo>(`${this.apiUrl}/${id}`,cargo)
  }

}
