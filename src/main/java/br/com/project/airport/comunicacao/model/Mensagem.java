package br.com.project.airport.comunicacao.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Mensagem {

    @Id
    private String idMensagem;

    @Column(nullable = false)
    private String remetente;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = false)
    private LocalDateTime dataHora;


    public String getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(String idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
