package br.com.project.airport.regulamentacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Norma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoNorma;

    private String descricao;

    private String autoridadeResponsavel;

    public Norma() {
    }

    public Norma(String codigoNorma, String descricao, String autoridadeResponsavel) {
        this.codigoNorma = codigoNorma;
        this.descricao = descricao;
        this.autoridadeResponsavel = autoridadeResponsavel;
    }

    public String getCodigoNorma() {
        return codigoNorma;
    }

    public void setCodigoNorma(String codigoNorma) {
        this.codigoNorma = codigoNorma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutoridadeResponsavel() {
        return autoridadeResponsavel;
    }

    public void setAutoridadeResponsavel(String autoridadeResponsavel) {
        this.autoridadeResponsavel = autoridadeResponsavel;
    }
}
