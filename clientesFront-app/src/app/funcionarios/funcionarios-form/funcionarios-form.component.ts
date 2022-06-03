import { Component, OnInit } from '@angular/core';
import { Funcionarios } from '../funcionarios';

import { FuncionariosService } from "../../funcionarios.service";
import { Cargo } from 'src/app/cargos/cargo';
import { CargosService } from 'src/app/cargos.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-funcionarios-form',
  templateUrl: './funcionarios-form.component.html',
  styleUrls: ['./funcionarios-form.component.css']
})
export class FuncionariosFormComponent implements OnInit {

  funcionarios: Funcionarios;
  cargos: Cargo[];
  success: boolean = false;
  erros: String[];
  id: number;

  constructor(private service: FuncionariosService,
    private serviceCargo: CargosService,
    private router: Router,
    private activateRoute: ActivatedRoute) {
    this.funcionarios = new Funcionarios();
  }

  ngOnInit(): void {
    this.serviceCargo
      .getCargo()
      .subscribe(response => this.cargos = response)

    let params: Observable<Params> = this.activateRoute.params
    params.subscribe(urlParams => {
      this.id = urlParams['id']
      this.service
        .getFuncionarioById(this.id).subscribe(
          response => this.funcionarios = response,
          errorResponse => this.funcionarios = new Funcionarios()
        )
    })

  }

  onSubmit() {
    this.service.salvar(this.funcionarios).subscribe(Response => {
      this.success = true;
      this.erros = [];
      this.funcionarios = Response;
    }, ErroResponse => {
      this.success = false;
      this.erros = ErroResponse.error.errors;
    });
  }

  voltarListaFuncionarios() {
    this.router.navigate(['/funcionarios/lista'])
  }

}
