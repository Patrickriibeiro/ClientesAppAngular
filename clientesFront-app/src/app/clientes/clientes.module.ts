import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClienteslistComponent } from './clienteslist/clienteslist.component';


@NgModule({
  declarations: [
    ClientesFormComponent,
    ClienteslistComponent
  ],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule
  ],
  exports: [
    ClientesFormComponent,
    ClienteslistComponent
  ]
})
export class ClientesModule { }
