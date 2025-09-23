package br.com.project.airport.controlevoo.model;

import jakarta.persistence.*;

@Entity
public class ControleDeVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idControle;

    private String status;

    @OneToOne
    private Controlador controlador;

    @OneToOne
    private TorreDeControle torreDeControle;

    public ControleDeVoo() {
    }

    public ControleDeVoo(Long idControle, String status) {
        this.idControle = idControle;
        this.status = status;
    }

    public Long getIdControle() {
        return idControle;
    }

    public void setIdControle(Long idControle) {
        this.idControle = idControle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public TorreDeControle getTorreDeControle() {
        return torreDeControle;
    }

    public void setTorreDeControle(TorreDeControle torreDeControle) {
        this.torreDeControle = torreDeControle;
    }
}
