package br.com.project.airport.embarque.model;

import jakarta.persistence.*;

@Entity
public class Bagagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoBagagem;

    @Column
    private  String nome;

    @Column
    private Double peso;


    public Bagagem() {
    }

    public Bagagem(Long codigoBagagem, String nome, Double peso) {
        this.codigoBagagem = codigoBagagem;
        this.nome = nome;
        this.peso = peso;
    }

    public Long getCodigoBagagem() {
        return codigoBagagem;
    }

    public void setCodigoBagagem(Long codigoBagagem) {
        this.codigoBagagem = codigoBagagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
