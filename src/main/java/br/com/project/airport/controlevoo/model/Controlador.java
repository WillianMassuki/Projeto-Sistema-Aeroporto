package br.com.project.airport.controlevoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Controlador {

    @Id
    private Long idControlador;

    private String nome;

    private String matricula;

    public Controlador() {
    }

    public Controlador(Long id, String nome, String matricula) {
        this.idControlador = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getIdControlador() {
        return idControlador;
    }

    public void setIdControlador(Long id) {
        this.idControlador = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
