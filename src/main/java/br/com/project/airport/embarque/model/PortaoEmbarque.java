package br.com.project.airport.embarque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PortaoEmbarque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idPortao;

    public PortaoEmbarque() {
    }

    public PortaoEmbarque(String idPortao) {
        this.idPortao = idPortao;
    }

    public String getIdPortao() {
        return idPortao;
    }

    public void setIdPortao(String idPortao) {
        this.idPortao = idPortao;
    }


//   private Voo voo;

    public void autorizarPassagem() {

    }
}
