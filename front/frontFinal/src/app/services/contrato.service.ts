import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Contrato {
  id?: number;
  identificador: string;
  valor: number;
  nombreContratante: string;
  documentoContratante: string;
  nombreContratantista: string;
  documentoContratantista: string;
  fechaInicial: string;
  fechaFinal: string;
}

@Injectable({
  providedIn: 'root',
})
export class ContratoService {
  private apiUrl = 'http://localhost:8080/api/contratos';

  constructor(private http: HttpClient) {}

  getContratos(): Observable<Contrato[]> {
    return this.http.get<Contrato[]>(this.apiUrl);
  }

  createContrato(contrato: Contrato): Observable<Contrato> {
    return this.http.post<Contrato>(this.apiUrl, contrato);
  }
}
