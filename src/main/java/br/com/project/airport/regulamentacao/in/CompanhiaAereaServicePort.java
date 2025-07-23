package br.com.project.airport.regulamentacao.in;

import br.com.project.airport.regulamentacao.model.CompanhiaAerea;

import java.util.List;
import java.util.Optional;

public interface CompanhiaAereaServicePort {
    CompanhiaAerea criarCompanhiaAerea(CompanhiaAerea companhiaAerea);
    Optional<CompanhiaAerea> buscarPorId(Long id);
    List<CompanhiaAerea> listarTodasCompanhias();
    CompanhiaAerea atualizarCompanhiaAerea(Long id, CompanhiaAerea companhiaAerea);
    void deletarCompanhia(Long id);
}
