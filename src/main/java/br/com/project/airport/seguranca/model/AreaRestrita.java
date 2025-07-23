package br.com.project.airport.seguranca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AreaRestrita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoAreaRestrita;

    private String nome;

    private String nivelRequerido;

    public AreaRestrita() {
    }

    public AreaRestrita(Long codigoAreaRestrita, String nome, String nivelRequerido) {
        this.codigoAreaRestrita = codigoAreaRestrita;
        this.nome = nome;
        this.nivelRequerido = nivelRequerido;
    }

    public Long getCodigoAreaRestrita() {
        return codigoAreaRestrita;
    }

    public void setCodigoAreaRestrita(Long codigoAreaRestrita) {
        this.codigoAreaRestrita = codigoAreaRestrita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivelRequerido() {
        return nivelRequerido;
    }

    public void setNivelRequerido(String nivelRequerido) {
        this.nivelRequerido = nivelRequerido;
    }
}
