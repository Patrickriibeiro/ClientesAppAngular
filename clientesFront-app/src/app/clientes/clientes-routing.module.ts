import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClienteslistComponent } from './clienteslist/clienteslist.component';

const routes: Routes = [
  {
    path: 'clientes', component: LayoutComponent, children: [

      { path: 'form', component: ClientesFormComponent },

      { path: 'lista', component: ClienteslistComponent },

      { path: 'form/:id', component: ClientesFormComponent },

      {path : '' , redirectTo: '/clientes/lista', pathMatch: 'full' }

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
