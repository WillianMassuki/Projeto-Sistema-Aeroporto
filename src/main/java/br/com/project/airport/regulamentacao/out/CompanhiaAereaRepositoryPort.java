package br.com.project.airport.regulamentacao.out;

import br.com.project.airport.regulamentacao.model.CompanhiaAerea;

import java.util.List;
import java.util.Optional;

public interface CompanhiaAereaRepositoryPort {
    CompanhiaAerea salvar(CompanhiaAerea companhiaAerea);
    Optional<CompanhiaAerea> buscarPorId(Long id);
    List<CompanhiaAerea> buscarTodas();
    void deletarPorId(Long id);
}
