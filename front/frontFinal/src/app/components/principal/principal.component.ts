import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ContratoService, Contrato } from '../../services/contrato.service';

@Component({
  standalone: true,
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss'],
  imports: [CommonModule, FormsModule],
})
export class PrincipalComponent implements OnInit {
  contratos: Contrato[] = [];
  nuevoContrato: Contrato = {
    identificador: '',
    valor: 0,
    nombreContratante: '',
    documentoContratante: '',
    nombreContratantista: '',
    documentoContratantista: '',
    fechaInicial: '',
    fechaFinal: '',
  };

  constructor(private contratoService: ContratoService) {}

  ngOnInit(): void {
    this.obtenerContratos();
  }

  obtenerContratos(): void {
    this.contratoService.getContratos().subscribe((data) => {
      this.contratos = data;
    });
  }

  onSubmit(): void {
    this.contratoService.createContrato(this.nuevoContrato).subscribe(() => {
      this.obtenerContratos();
      this.nuevoContrato = {
        identificador: '',
        valor: 0,
        nombreContratante: '',
        documentoContratante: '',
        nombreContratantista: '',
        documentoContratantista: '',
        fechaInicial: '',
        fechaFinal: '',
      };
    });
  }
}