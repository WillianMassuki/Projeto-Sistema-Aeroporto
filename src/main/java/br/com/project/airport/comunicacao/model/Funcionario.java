package br.com.project.airport.comunicacao.model;

import jakarta.persistence.*;


@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFuncionario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false, unique = true)
    private String matricula;

    // opcional — só se quiser o relacionamento bidirecional
    @OneToOne(mappedBy = "funcionario")
    private Informacao informacao;


    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cargo, String matricula) {
        this.idFuncionario = id;
        this.nome = nome;
        this.cargo = cargo;
        this.matricula = matricula;
    }

    public Long getId() {
        return idFuncionario;
    }

    public void setId(Long id) {
        this.idFuncionario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
