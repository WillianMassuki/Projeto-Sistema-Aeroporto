package br.com.project.airport.regulamentacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoInspecao;

    private LocalDate data;

    private String resultado;

    private String observacoes;

    public Inspecao() {
    }

    public Inspecao(Long codigoInspecao, LocalDate data, String resultado, String observacoes) {
        this.codigoInspecao = codigoInspecao;
        this.data = data;
        this.resultado = resultado;
        this.observacoes = observacoes;
    }

    public Long getCodigoInspecao() {
        return codigoInspecao;
    }

    public void setCodigoInspecao(Long codigoInspecao) {
        this.codigoInspecao = codigoInspecao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
