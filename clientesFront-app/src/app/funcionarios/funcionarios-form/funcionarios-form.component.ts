import { Component, OnInit } from '@angular/core';
import { Funcionarios } from '../funcionarios';

import { FuncionariosService } from "../../funcionarios.service";
import { Cargo } from 'src/app/cargos/cargo';
import { CargosService } from 'src/app/cargos.service';

@Component({
  selector: 'app-funcionarios-form',
  templateUrl: './funcionarios-form.component.html',
  styleUrls: ['./funcionarios-form.component.css']
})
export class FuncionariosFormComponent implements OnInit {

  funcionarios: Funcionarios;
  cargos: Cargo[];

  constructor(private service: FuncionariosService,private serviceCargo: CargosService) {
    this.funcionarios = service.getFuncionario();
  }

  ngOnInit(): void {
    this.serviceCargo
    .getCargo()
    .subscribe( response => this.cargos = response)
  }

  onSubmit() {
    this.service.salvar(this.funcionarios).subscribe( Response => console.log(this.funcionarios));
  }

}
