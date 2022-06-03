import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from 'src/app/clientes/cliente';
import { ServicoPrestadoService } from 'src/app/servico-prestado.service';
import { ServicoPrestadoBusca } from './servicePrestadoBusca';

@Component({
  selector: 'app-servico-prestado-lista',
  templateUrl: './servico-prestado-lista.component.html',
  styleUrls: ['./servico-prestado-lista.component.css']
})
export class ServicoPrestadoListaComponent implements OnInit {

  nome: string;
  mes: number;
  meses: number[];
  lista: ServicoPrestadoBusca[];
  clientes : Cliente[];
  message: string;

  constructor(
    private service: ServicoPrestadoService,private clienteService: ClientesService
  ) {
    this.meses = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
  }

  ngOnInit(): void {
    this.clienteService
    .getClientes()
    .subscribe(response => this.clientes = response);
  }

  consultar() {
    console.log(this.nome,this.mes)
    this.service.buscar(this.nome,this.mes)
    .subscribe( response => {
      this.lista = response     
      if(this.lista.length <= 0)
      this.message = "Nenhum Registro encontrado."
      else 
      this.message = '';  
    })
  }

}
