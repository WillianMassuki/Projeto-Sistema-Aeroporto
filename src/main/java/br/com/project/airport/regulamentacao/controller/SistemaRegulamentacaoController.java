package br.com.project.airport.regulamentacao.controller;

import br.com.project.airport.regulamentacao.model.Inspecao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sistemaregulamentar")
public class SistemaRegulamentacaoController {


    /*
    public Boolean verificarConformidade(EntidadeRegulada entidade) {
        return true;
    }

     */

    public void registrarInspecao(Inspecao inspecao) {

    }

    public void gerarRelatorioConformidade() {

    }

}
