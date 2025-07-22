package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idFornecedor;

    private String nome;

    private String servicoPrestado;

    public Fornecedor() {
    }

    public Fornecedor(String idFornecedor, String nome, String servicoPrestado) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.servicoPrestado = servicoPrestado;
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {
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
}
