package br.com.project.airport.controlevoo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TorreDeControle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTorre;

    private String localizacao;

    @OneToMany(mappedBy = "torreDeControle")
    private List<ControleDeVoo> controles = new ArrayList<>();

    public TorreDeControle() {
    }

    public TorreDeControle(Long idTorre, String localizacao) {
        this.idTorre = idTorre;
        this.localizacao = localizacao;
    }

    public Long getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(Long idTorre) {
        this.idTorre = idTorre;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<ControleDeVoo> getControles() {
        return controles;
    }

    public void setControles(List<ControleDeVoo> controles) {
        this.controles = controles;
    }
}