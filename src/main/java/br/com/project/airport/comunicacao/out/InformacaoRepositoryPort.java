package br.com.project.airport.comunicacao.out;

import br.com.project.airport.comunicacao.model.Informacao;

import java.util.List;
import java.util.Optional;

public interface InformacaoRepositoryPort {
    Informacao salvar(Informacao informacao);
    Optional<Informacao> buscarPorId(String id);
    List<Informacao> buscarTodos();
    void deletarPorId(String id);

}
