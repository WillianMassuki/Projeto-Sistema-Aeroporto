package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornecedor;

    private String nome;

    private String servicoPrestado;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor, String nome, String servicoPrestado, List<Despesa> despesas) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.servicoPrestado = servicoPrestado;
        this.despesas = despesas;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServicoPrestado() {
        return servicoPrestado;
    }

    public void setServicoPrestado(String servicoPrestado) {
        this.servicoPrestado = servicoPrestado;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
