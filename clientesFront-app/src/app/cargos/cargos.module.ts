import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CargosRoutingModule } from './cargos-routing.module';
import { CargosFormComponent } from './cargos-form/cargos-form.component';
import { FormsModule } from '@angular/forms'
import { RouterModule } from '@angular/router';
import { CargoListaComponent } from './cargo-lista/cargo-lista.component';


@NgModule({
  declarations: [
    CargosFormComponent,
    CargoListaComponent
  ],
  imports: [
    CommonModule,
    CargosRoutingModule,
    FormsModule,
    RouterModule
  ], exports: [
    CommonModule,
    CargosFormComponent,
    CargoListaComponent
  ]
})
export class CargosModule { }
