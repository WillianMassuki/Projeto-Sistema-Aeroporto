package br.com.project.airport.regulamentacao.in;

import br.com.project.airport.gestaorecurso.model.Pista;
import br.com.project.airport.regulamentacao.model.Inspecao;

import java.util.List;
import java.util.Optional;

public interface InspecaoServicePort {
    Inspecao criarInspecao(Inspecao inspecao);
    Optional<Inspecao> buscarPorId(Long id);
    List<Inspecao> listarTodasInpecoes();
    Pista atualizarInspecao(Long id, Inspecao inspecao);
    void deletarInspecao(Long id);
}
