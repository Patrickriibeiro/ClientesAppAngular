import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesFormComponent } from '../clientes/clientes-form/clientes-form.component';
import { LayoutComponent } from '../layout/layout.component';
import { FuncionariosFormComponent } from './funcionarios-form/funcionarios-form.component';
import { FuncionariosListComponent } from './funcionarios-list/funcionarios-list.component';

const routes: Routes = [
  { path : 'funcionarios', component : LayoutComponent, children: [
    {path : 'form', component : FuncionariosFormComponent},
    {path : 'lista', component : FuncionariosListComponent},
    { path: 'form/:id', component: FuncionariosFormComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FuncionariosRoutingModule { }
