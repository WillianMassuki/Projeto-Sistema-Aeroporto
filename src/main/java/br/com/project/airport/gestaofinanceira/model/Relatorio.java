package br.com.project.airport.gestaofinanceira.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRelatorio;

    private LocalDate periodoInicio;
    private LocalDate periodoFim;

    @OneToMany(mappedBy = "relatorio", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

    @OneToMany(mappedBy = "relatorio", cascade = CascadeType.ALL)
    private List<Receita> receitas;



    public Relatorio() {
    }

    public Relatorio(Long idRelatorio, LocalDate periodoInicio, LocalDate periodoFim, List<Despesa> despesas, List<Receita> receitas) {
        this.idRelatorio = idRelatorio;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.despesas = despesas;
        this.receitas = receitas;
    }

    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
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

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
}
