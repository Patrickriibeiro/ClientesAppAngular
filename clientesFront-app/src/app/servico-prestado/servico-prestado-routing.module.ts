import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ServicoPrestadoFormComponent } from './servico-prestado-form/servico-prestado-form.component';
import { ServicoPrestadoListaComponent } from './servico-prestado-lista/servico-prestado-lista.component';

const routes: Routes = [
  { path : 'servico-prestado-form', component: ServicoPrestadoFormComponent },
  { path : 'servico-prestado-listagem', component: ServicoPrestadoListaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServicoPrestadoRoutingModule { }
