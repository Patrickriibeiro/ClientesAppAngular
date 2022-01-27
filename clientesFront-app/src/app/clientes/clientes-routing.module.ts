import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClienteslistComponent } from './clienteslist/clienteslist.component';

const routes: Routes = [
  { path : 'clientes-form' , component : ClientesFormComponent},
  { path : 'clientes-lista', component : ClienteslistComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
