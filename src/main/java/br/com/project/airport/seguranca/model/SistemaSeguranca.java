package br.com.project.airport.seguranca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SistemaSeguranca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String idSistemaSeguranca;

    public SistemaSeguranca() {
    }

    public SistemaSeguranca(String idSistemaSeguranca) {
        this.idSistemaSeguranca = idSistemaSeguranca;
    }

    public String getIdSistemaSeguranca() {
        return idSistemaSeguranca;
    }

    public void setIdSistemaSeguranca(String idSistemaSeguranca) {
        this.idSistemaSeguranca = idSistemaSeguranca;
    }
}
