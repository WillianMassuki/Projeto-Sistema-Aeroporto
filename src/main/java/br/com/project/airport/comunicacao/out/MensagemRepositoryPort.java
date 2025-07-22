package br.com.project.airport.comunicacao.out;

import br.com.project.airport.comunicacao.model.Mensagem;

import java.util.List;
import java.util.Optional;

public interface MensagemRepositoryPort {

    Mensagem salvar(Mensagem mensagem);
    Optional<Mensagem> buscarPorId(String id);
    List<Mensagem> buscarTodos();
    void deletarPorId(String id);
}
