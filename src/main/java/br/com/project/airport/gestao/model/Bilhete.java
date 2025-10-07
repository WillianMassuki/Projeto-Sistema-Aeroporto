package br.com.project.airport.gestao.model;

import br.com.project.airport.embarque.model.Bagagem;
import jakarta.persistence.*;

@Entity
public class Bilhete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBilhete;

    private Integer numero;

    private String assento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo")
    private Bagagem bagagem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoPassageiro")
    private Passageiro passageiro;

    public Bilhete() {
    }

    public Bilhete(Long idBilhete, Integer numero, String assento, Bagagem bagagem, Passageiro passageiro) {
        this.idBilhete = idBilhete;
        this.numero = numero;
        this.assento = assento;
        this.bagagem = bagagem;
        this.passageiro = passageiro;
    }

    public Long getIdBilhete() {
        return idBilhete;
    }

    public void setIdBilhete(Long idBilhete) {
        this.idBilhete = idBilhete;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public boolean getBagagem() {
        return bagagem;
    }

    public void setBagagem(boolean bagagem) {
        this.bagagem = bagagem;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    //  private Voo voo;

    public static void main() {

    }


}
