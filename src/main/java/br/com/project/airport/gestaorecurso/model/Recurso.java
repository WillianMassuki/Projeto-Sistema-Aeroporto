package br.com.project.airport.gestaorecurso.model;

import jakarta.persistence.*;

@Entity
public  class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecurso;

    private String tipo;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_pista")
    private Pista pista;

    public String alocar() {

        return "";
    }

    public String liberar() {

        return "";
    }

    public Recurso() {
    }

    public Recurso(Long idRecurso, String tipo, String status, Pista pista) {
        this.idRecurso = idRecurso;
        this.tipo = tipo;
        this.status = status;
        this.pista = pista;
    }

    public Long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Long idRecurso) {
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

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }
}
