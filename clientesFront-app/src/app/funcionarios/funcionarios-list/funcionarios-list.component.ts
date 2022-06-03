import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FuncionariosService } from 'src/app/funcionarios.service';
import { Funcionarios } from '../funcionarios';

@Component({
  selector: 'app-funcionarios-list',
  templateUrl: './funcionarios-list.component.html',
  styleUrls: ['./funcionarios-list.component.css']
})
export class FuncionariosListComponent implements OnInit {

funcionarios : Funcionarios[];

  constructor(private service : FuncionariosService,private router : Router) { 
  }


  ngOnInit(): void {
    this.service.getFuncionarios()
    .subscribe( response => this.funcionarios = response);
  }

  novoCadastro(){
    this.router.navigate(['/funcionarios/form'])
  }
}
