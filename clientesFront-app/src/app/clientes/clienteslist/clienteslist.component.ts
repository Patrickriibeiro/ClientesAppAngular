import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';  

@Component({
  selector: 'clientes-lista',
  templateUrl: './clienteslist.component.html',
  styleUrls: ['./clienteslist.component.css']
})
export class ClienteslistComponent implements OnInit {

  clientes?: Cliente[];

  constructor(private service: ClientesService) { }

  ngOnInit(): void {
    this.service
    .getClientes()
    .subscribe( resposta => this.clientes = resposta)
  }
}
