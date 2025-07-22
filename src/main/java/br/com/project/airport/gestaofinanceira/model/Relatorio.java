package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idRelatorio;

    private LocalDate periodoInicio;

    private LocalDate periodoFim;

    public Relatorio() {
    }

    public Relatorio(String idRelatorio, LocalDate periodoInicio, LocalDate periodoFim) {
        this.idRelatorio = idRelatorio;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
    }

    public String getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(String idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public LocalDate getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(LocalDate periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public LocalDate getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(LocalDate periodoFim) {
        this.periodoFim = periodoFim;
    }
}
