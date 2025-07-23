package br.com.project.airport.regulamentacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoAuditor;

    public String nome;

    public String matricula;

    public Auditor() {
    }

    public Auditor(Long codigoAuditor, String nome, String matricula) {
        this.codigoAuditor = codigoAuditor;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getCodigoAuditor() {
        return codigoAuditor;
    }

    public void setCodigoAuditor(Long codigoAuditor) {
        this.codigoAuditor = codigoAuditor;
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
