import { Component, OnInit } from '@angular/core';
import { Funcioarios } from '../funcionarios';

@Component({
  selector: 'app-funcionarios-form',
  templateUrl: './funcionarios-form.component.html',
  styleUrls: ['./funcionarios-form.component.css']
})
export class FuncionariosFormComponent implements OnInit {

  funciarios: Funcioarios;

  constructor() { }

  ngOnInit(): void {
  }

}
