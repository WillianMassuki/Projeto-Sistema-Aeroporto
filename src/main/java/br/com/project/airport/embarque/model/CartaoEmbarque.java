package br.com.project.airport.embarque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CartaoEmbarque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoCartaoEmbarque;

    private String assento;

    public CartaoEmbarque() {
    }

    public CartaoEmbarque(String codigoCartaoEmbarque, String assento) {
        this.codigoCartaoEmbarque = codigoCartaoEmbarque;
        this.assento = assento;
    }

    public String getCodigoCartaoEmbarque() {
        return codigoCartaoEmbarque;
    }

    public void setCodigoCartaoEmbarque(String codigoCartaoEmbarque) {
        this.codigoCartaoEmbarque = codigoCartaoEmbarque;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    //   private Voo voo;
}
