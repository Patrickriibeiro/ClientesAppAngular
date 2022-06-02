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

  getCargo(): Observable<Cargo[]> {
    return this.http.get<Cargo[]>(this.apiUrl);
  }
}
