import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from 'src/app/clientes/cliente';
import { ServicoPrestado } from '../servicoPrestado';
import { Funcionarios } from 'src/app/funcionarios/funcionarios';
import { ServicoPrestadoService } from 'src/app/servico-prestado.service';
import { FuncionariosService } from 'src/app/funcionarios.service';


@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[]
  servico: ServicoPrestado;
  success: boolean = false;
  funcionarios : Funcionarios[];
  errors: String[];

  constructor(private clienteService: ClientesService, 
    private servicePrestado: ServicoPrestadoService,
    private funcionarioServico : FuncionariosService) { 
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {
    this.clienteService
    .getClientes()
    .subscribe(response => this.clientes = response);

    this.funcionarioServico.getFuncionarios()
    .subscribe(response => this.funcionarios = response);
  }

  onSubmit(){
    console.log(this.servico)
    this.servicePrestado
    .salvar(this.servico)
    .subscribe( response => {
      console.log(this.servico);
      this.success = true;
      this.errors = [];
      this.servico = new ServicoPrestado();
    }, errorResponse => {
      this.success = false;
      this.errors = errorResponse.error.errors;
    })
  }
}
