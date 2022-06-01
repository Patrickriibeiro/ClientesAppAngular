import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuncionariosRoutingModule } from './funcionarios-routing.module';
import { FuncionariosFormComponent } from './funcionarios-form/funcionarios-form.component';
import { FuncionariosListComponent } from './funcionarios-list/funcionarios-list.component';
import { FormsModule } from '@angular/forms'
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    FuncionariosFormComponent,
    FuncionariosListComponent
  ],
  imports: [
    CommonModule,
    FuncionariosRoutingModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    CommonModule,
    FuncionariosRoutingModule
  ]
})
export class FuncionariosModule { }
