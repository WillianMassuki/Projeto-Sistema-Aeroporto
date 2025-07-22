package br.com.project.airport.gestaofinanceira.controller;


import br.com.project.airport.gestaofinanceira.model.Despesa;
import br.com.project.airport.gestaofinanceira.model.Receita;
import br.com.project.airport.gestaofinanceira.model.Relatorio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SistemaFinanceiro")
public class SistemaGestaoFinanceiraController {

    public void registrarReceita(Receita receita) {

    }

    public void registrarDespesa(Despesa despesa) {

    }

    public Relatorio gerarRelatorioFinanceiro() {

        return null;
    }

}
