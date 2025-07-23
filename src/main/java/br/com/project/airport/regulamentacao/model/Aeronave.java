package br.com.project.airport.regulamentacao.model;

import jakarta.persistence.*;

@Entity
public class Aeronave{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoAeronave;

    private String modelo;

    private String registro;

    private String statusCertificacao;

    public Aeronave() {
    }

    public Aeronave(Long codigoAeronave, String modelo, String registro, String statusCertificacao) {
        this.codigoAeronave = codigoAeronave;
        this.modelo = modelo;
        this.registro = registro;
        this.statusCertificacao = statusCertificacao;
    }

    public Long getCodigoAeronave() {
        return codigoAeronave;
    }

    public void setCodigoAeronave(Long codigoAeronave) {
        this.codigoAeronave = codigoAeronave;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getStatusCertificacao() {
        return statusCertificacao;
    }

    public void setStatusCertificacao(String statusCertificacao) {
        this.statusCertificacao = statusCertificacao;
    }
}
