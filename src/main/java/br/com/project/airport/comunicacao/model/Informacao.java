package br.com.project.airport.comunicacao.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Informacao {

    @Id
    private String idInformacao;

    @Column(nullable = false)
    private String tipo;  // exemplo: "embarque", "atraso"

    @OneToOne
    @Column(nullable = false)
    private Mensagem conteudo;

    @Column(nullable = false)
    private LocalDateTime validade;

    @OneToOne
    private Funcionario funcionario;

    public String getIdInformacao() {
        return idInformacao;
    }

    public void setIdInformacao(String idInformacao) {
        this.idInformacao = idInformacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Mensagem getConteudo() {
        return conteudo;
    }

    public void setConteudo(Mensagem conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }

    public Informacao(String idInformacao, String tipo, Mensagem conteudo, LocalDateTime validade) {
        this.idInformacao = idInformacao;
        this.tipo = tipo;
        this.conteudo = conteudo;
        this.validade = validade;
    }



    public Informacao() {
    }
}