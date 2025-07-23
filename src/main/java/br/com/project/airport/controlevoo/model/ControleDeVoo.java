package br.com.project.airport.controlevoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ControleDeVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idControle;

    private String status;

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
}
