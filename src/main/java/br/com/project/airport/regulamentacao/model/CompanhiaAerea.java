package br.com.project.airport.regulamentacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompanhiaAerea{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoCompanhiaAerea;

    public String codigoICAO;

    public String paisOrigem;


    public CompanhiaAerea() {
    }

    public CompanhiaAerea(Long codigoCompanhiaAerea, String codigoICAO, String paisOrigem) {
        this.codigoCompanhiaAerea = codigoCompanhiaAerea;
        this.codigoICAO = codigoICAO;
        this.paisOrigem = paisOrigem;
    }

    public Long getCodigoCompanhiaAerea() {
        return codigoCompanhiaAerea;
    }

    public void setCodigoCompanhiaAerea(Long codigoCompanhiaAerea) {
        this.codigoCompanhiaAerea = codigoCompanhiaAerea;
    }

    public String getCodigoICAO() {
        return codigoICAO;
    }

    public void setCodigoICAO(String codigoICAO) {
        this.codigoICAO = codigoICAO;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
}

