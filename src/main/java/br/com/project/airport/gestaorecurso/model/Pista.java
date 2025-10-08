package br.com.project.airport.gestaorecurso.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Pista{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPista;

    private String status;

    @OneToMany(mappedBy = "pista")
    private List<Recurso> recursos;

    @OneToMany(mappedBy = "pista")
    private List<VeiculoApoio> veiculosApoio;


    public Pista(Long idPista, String status, List<Recurso> recursos, List<VeiculoApoio> veiculosApoio) {
        this.idPista = idPista;
        this.status = status;
        this.recursos = recursos;
        this.veiculosApoio = veiculosApoio;
    }

    public Pista() {
    }

    public Long getIdPista() {
        return idPista;
    }

    public void setIdPista(Long idPista) {
        this.idPista = idPista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public List<VeiculoApoio> getVeiculosApoio() {
        return veiculosApoio;
    }

    public void setVeiculosApoio(List<VeiculoApoio> veiculosApoio) {
        this.veiculosApoio = veiculosApoio;
    }
}
