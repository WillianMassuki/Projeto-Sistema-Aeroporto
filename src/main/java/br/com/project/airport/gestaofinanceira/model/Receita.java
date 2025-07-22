package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Receita {

    @Id
    private String idReceita;

    // «taxa de pouso», «aluguel», etc.
    private String tipo;

    private Double valor;

    private LocalDateTime data;

    private String descricao;

    public Receita() {
    }

    public Receita(String idReceita, String tipo, Double valor, LocalDateTime data, String descricao) {
        this.idReceita = idReceita;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public String getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(String idReceita) {
        this.idReceita = idReceita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
