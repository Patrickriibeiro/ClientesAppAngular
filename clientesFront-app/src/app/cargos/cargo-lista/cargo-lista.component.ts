import { Component, OnInit } from '@angular/core';
import { CargosService } from 'src/app/cargos.service';
import { Cargo } from '../cargo'
import { Router } from '@angular/router';

@Component({
  selector: 'app-cargo-lista',
  templateUrl: './cargo-lista.component.html',
  styleUrls: ['./cargo-lista.component.css']
})
export class CargoListaComponent implements OnInit {

  cargos : Cargo[];
  cargoSelecionado: Cargo;
  mensagemSucesso : string;
  erros : string[];

  constructor(private cargoService : CargosService,private router : Router) { }

  ngOnInit(): void {
    this.cargoService.getCargos().subscribe(Response => {
      this.cargos = Response;
    })
  }

  preparaDelecao(cargo: Cargo){
    this.cargoSelecionado = cargo;
  }

  novoCadastro(){
    this.router.navigate(['/cargo/form'])
  }

  deletarCargo(){
    this.cargoService.deletarCargoById(this.cargoSelecionado.id).subscribe(Response => { 
      this.mensagemSucesso = 'Funcionario deletado com sucesso';
      this.ngOnInit();
    },Error => {
      this.erros = Error.error.errors;
    })
  }

}
