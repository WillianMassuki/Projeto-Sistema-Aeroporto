package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReceita;

    private String tipo;
    private Double valor;
    private LocalDateTime data;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_relatorio")
    private Relatorio relatorio;

    public Receita() {
    }

    public Receita(Long idReceita, String tipo, Double valor, LocalDateTime data, String descricao, Relatorio relatorio) {
        this.idReceita = idReceita;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.relatorio = relatorio;
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
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

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }
}
