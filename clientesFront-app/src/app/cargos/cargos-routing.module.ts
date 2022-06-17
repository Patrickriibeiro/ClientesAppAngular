import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CargosFormComponent } from './cargos-form/cargos-form.component';
import { LayoutComponent } from '../layout/layout.component'
import { CargoListaComponent } from './cargo-lista/cargo-lista.component';

const routes: Routes = [
  {
    path: 'cargo', component: LayoutComponent, children: [
      { path: 'form', component: CargosFormComponent },
      { path: 'lista', component: CargoListaComponent },
      { path: 'form/:id', component: CargosFormComponent },
      {path : '' , redirectTo: '/cargo/lista', pathMatch: 'full' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CargosRoutingModule { }
