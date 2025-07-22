package br.com.project.airport.gestao.model;

import jakarta.persistence.*;

@Entity
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAeroporto;

    @Column
    private String nome;

    @Column
    private String codigo;


    public Aeroporto() {
    }

    public Aeroporto(Long idAeroporto, String nome, String codigo) {
        this.idAeroporto = idAeroporto;
        this.nome = nome;
        this.codigo = codigo;
    }

    public Long getIdAeroporto() {
        return idAeroporto;
    }

    public void setIdAeroporto(Long idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
