package br.com.project.airport.seguranca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CartaoAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idCartao;

    private String nivelAcesso;

    public Boolean validar(AreaRestrita area) {
        return null;
    }

    public CartaoAcesso() {
    }

    public CartaoAcesso(String idCartao, String nivelAcesso) {
        this.idCartao = idCartao;
        this.nivelAcesso = nivelAcesso;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
