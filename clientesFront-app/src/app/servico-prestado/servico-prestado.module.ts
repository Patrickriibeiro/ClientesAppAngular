import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@Angular/forms'

import { ServicoPrestadoRoutingModule } from './servico-prestado-routing.module';
import { ServicoPrestadoListaComponent } from './servico-prestado-lista/servico-prestado-lista.component';
import { ServicoPrestadoFormComponent } from './servico-prestado-form/servico-prestado-form.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    ServicoPrestadoListaComponent,
    ServicoPrestadoFormComponent
  ],
  imports: [
    CommonModule,
    ServicoPrestadoRoutingModule,
    FormsModule,
    RouterModule
  ], exports: [
    ServicoPrestadoListaComponent,
    ServicoPrestadoFormComponent
  ]
})
export class ServicoPrestadoModule { }
