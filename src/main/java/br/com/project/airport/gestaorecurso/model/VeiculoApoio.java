package br.com.project.airport.gestaorecurso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class VeiculoApoio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String placa;

    public String tipoVeiculo;

    public Boolean emUso;

    public VeiculoApoio() {
    }

    public VeiculoApoio(String placa, String tipoVeiculo, Boolean emUso) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.emUso = emUso;
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
}
