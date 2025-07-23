package br.com.project.airport.gestaorecurso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public  class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idRecurso;

    private String tipo;

    private String status;

    public String alocar() {

        return "";
    }

    public String liberar() {

        return "";
    }


    public Recurso() {
    }

    public Recurso(String idRecurso, String tipo, String status) {
        this.idRecurso = idRecurso;
        this.tipo = tipo;
        this.status = status;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
