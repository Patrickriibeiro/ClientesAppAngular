import { Cliente } from "src/app/clientes/cliente";
import { Funcionarios } from "src/app/funcionarios/funcionarios";

export class ServicoPrestadoBusca {
    descricao: string;
    valor: number;
    data: string;
    cliente: Cliente;
    funcionario: Funcionarios
}