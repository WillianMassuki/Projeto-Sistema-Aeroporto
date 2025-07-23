package br.com.project.airport.seguranca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class RegistroAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoRegistroAcesso;

    private LocalDateTime horario;

    // «permitido», «negado»
    private String resultado() {
        return "0 ";
    }

    public RegistroAcesso() {
    }

    public RegistroAcesso(Long codigoRegistroAcesso, LocalDateTime horario) {
        this.codigoRegistroAcesso = codigoRegistroAcesso;
        this.horario = horario;
    }

    public Long getCodigoRegistroAcesso() {
        return codigoRegistroAcesso;
    }

    public void setCodigoRegistroAcesso(Long codigoRegistroAcesso) {
        this.codigoRegistroAcesso = codigoRegistroAcesso;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
}
