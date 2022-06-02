import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CargosRoutingModule } from './cargos-routing.module';
import { CargosFormComponent } from './cargos-form/cargos-form.component';


@NgModule({
  declarations: [
    CargosFormComponent
  ],
  imports: [
    CommonModule,
    CargosRoutingModule
  ], exports: [
    CommonModule,
    CargosFormComponent
  ]
})
export class CargosModule { }
