package com.example.demo.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contrato") // Especifica el nombre de la tabla
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Incremental para la clave primaria
    private Long id;

    @Column(nullable = false, length = 255) // No puede ser nulo y longitud máxima de 255
    private String identificador;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "nombre_contratante", nullable = false, length = 255)
    private String nombreContratante;

    @Column(name = "documento_contratante", nullable = false, length = 255)
    private String documentoContratante;

    @Column(name = "nombre_contratantista", nullable = false, length = 255)
    private String nombreContratantista;

    @Column(name = "documento_contratantista", nullable = false, length = 255)
    private String documentoContratantista;

    @Column(name = "fecha_inicial", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;

    @Column(name = "fecha_final", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public String getDocumentoContratante() {
        return documentoContratante;
    }

    public void setDocumentoContratante(String documentoContratante) {
        this.documentoContratante = documentoContratante;
    }

    public String getNombreContratantista() {
        return nombreContratantista;
    }

    public void setNombreContratantista(String nombreContratantista) {
        this.nombreContratantista = nombreContratantista;
    }

    public String getDocumentoContratantista() {
        return documentoContratantista;
    }

    public void setDocumentoContratantista(String documentoContratantista) {
        this.documentoContratantista = documentoContratantista;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
