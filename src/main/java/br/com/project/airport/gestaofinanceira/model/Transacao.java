package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private String idTransacao;

  private LocalDate data;

   private Double valor;

   //(«entrada» ou «saída»)
   private String tipo;

    public Transacao() {
    }

    public Transacao(String idTransacao, LocalDate data, Double valor, String tipo) {
        this.idTransacao = idTransacao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
