package br.com.project.airport.gestaorecurso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pista{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idPista;

    private String status;

    public Pista(Long codigoAeronave, String statusCertificacao) {
    }

    public Pista(String idPista, String status) {
        this.idPista = idPista;
        this.status = status;
    }

    public Pista() {

    }

    public String getIdPista() {
        return idPista;
    }

    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
