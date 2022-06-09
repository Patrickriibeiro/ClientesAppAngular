import { Component, OnInit } from '@angular/core';
import { CargosService } from 'src/app/cargos.service';
import { Cargo } from '../cargo';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cargos-form',
  templateUrl: './cargos-form.component.html',
  styleUrls: ['./cargos-form.component.css']
})
export class CargosFormComponent implements OnInit {

  cargo: Cargo;
  success: boolean = false;
  erros: String[];
  id: number;

  constructor(private serviceCargo: CargosService,
    private router: Router,
    private activateRoute: ActivatedRoute) {
    this.cargo = new Cargo();
  }

  ngOnInit(): void {
    let params: Observable<Params> = this.activateRoute.params
    params.subscribe(urlParams => {
      this.id = urlParams['id']
      this.serviceCargo
        .getCargoById(this.id).subscribe(
          response => this.cargo = response,
          errorResponse => this.cargo = new Cargo()
        )
    })
  }

  onSubmit() {
    if (this.id) {
      this.serviceCargo.atualizarCargoById(this.id,this.cargo)
        .subscribe(Response => {
          this.success = true;
          this.cargo = Response
          this.erros = [];
        }, ErroResponse => {
          this.success = false;
          this.erros = ['Funcionario não atualizado com sucesso.']
        });
    } else {
      this.serviceCargo.salvar(this.cargo).subscribe(Response => {
        this.success = true;
        this.erros = [];
        this.cargo = Response;
      }, ErroResponse => {
        this.success = false;
        this.erros = ErroResponse.error.errors;
      })
    }
  }

  voltarListaCargos() {
    this.router.navigate(['/cargo/lista'])
  }

}
