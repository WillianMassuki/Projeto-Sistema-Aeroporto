package br.com.project.airport.comunicacao.in;

import br.com.project.airport.comunicacao.model.Informacao;

import java.util.List;
import java.util.Optional;

public interface InformacaoUseCase {

    Informacao criar(Informacao informacao);
    Optional<Informacao> buscarPorId(String id);
    List<Informacao> listar();
    Informacao atualizar(String id, Informacao informacao);
    void deletar(String id);
}
