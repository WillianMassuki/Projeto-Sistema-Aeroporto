package br.com.project.airport.gestaorecurso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class VeiculoApoio{

    @Id
    private String placa;

    private String tipoVeiculo;
    private Boolean emUso;

    @ManyToOne
    @JoinColumn(name = "id_pista")
    private Pista pista;

    public VeiculoApoio() {
    }


    public VeiculoApoio(String placa, String tipoVeiculo, Boolean emUso, Pista pista) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.emUso = emUso;
        this.pista = pista;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Boolean getEmUso() {
        return emUso;
    }

    public void setEmUso(Boolean emUso) {
        this.emUso = emUso;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }
}
