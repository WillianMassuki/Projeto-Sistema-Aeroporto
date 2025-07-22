package br.com.project.airport.gestao.model;

import br.com.project.airport.comunicacao.model.Informacao;
import jakarta.persistence.*;

@Entity
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoPassageiro;

    private String nome;

    private String documento;

    @Column
    private String numeroCartao;


    public Passageiro() {
    }

    public Passageiro(Long codigoPassageiro, String nome, String documento, String numeroCartao) {
        this.codigoPassageiro = codigoPassageiro;
        this.nome = nome;
        this.documento = documento;
        this.numeroCartao = numeroCartao;
    }

    public Long getCodigoPassageiro() {
        return codigoPassageiro;
    }

    public void setCodigoPassageiro(Long codigoPassageiro) {
        this.codigoPassageiro = codigoPassageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    private void comprarBilhete() {

    }

    public String receberNotificacao(Informacao info) {

        return "";
    }
}
