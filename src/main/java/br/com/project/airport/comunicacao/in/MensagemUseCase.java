package br.com.project.airport.comunicacao.in;

import br.com.project.airport.comunicacao.model.Mensagem;

import java.util.List;
import java.util.Optional;

public interface MensagemUseCase {

    Mensagem criar(Mensagem mensagem);
    Optional<Mensagem> buscarPorId(String id);
    List<Mensagem> listar();
    Mensagem atualizar(String id, Mensagem mensagem);
    void deletar(String id);
}
