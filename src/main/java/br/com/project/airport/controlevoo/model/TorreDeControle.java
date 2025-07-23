package br.com.project.airport.controlevoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TorreDeControle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idTorre;

    private String localizacao;

    public TorreDeControle() {
    }

    public TorreDeControle(String idTorre, String localizacao) {
        this.idTorre = idTorre;
        this.localizacao = localizacao;
    }

    public String getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(String idTorre) {
        this.idTorre = idTorre;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}