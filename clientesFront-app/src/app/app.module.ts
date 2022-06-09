import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';
import { ClientesModule } from './clientes/clientes.module';
import { ClientesService } from './clientes.service';
import { ServicoPrestadoModule } from './servico-prestado/servico-prestado.module'; 
import { ServicoPrestadoService } from './servico-prestado.service';
import { LoginComponent } from './login/login.component';
import { LayoutComponent } from './layout/layout.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { FuncionariosModule } from './funcionarios/funcionarios.module';
import { FuncionariosService } from './funcionarios.service';
import { CargosService } from './cargos.service';
import { CargosModule } from './cargos/cargos.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    LayoutComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TemplateModule,
    ClientesModule,
    ServicoPrestadoModule,
    BrowserAnimationsModule,
    MatCardModule,
    FuncionariosModule,
    CargosModule
  ],
  providers: [
    ClientesService,
    ServicoPrestadoService,
    FuncionariosService,
    CargosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

