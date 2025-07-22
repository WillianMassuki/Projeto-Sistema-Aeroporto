package br.com.project.airport.embarque.in;

import br.com.project.airport.embarque.model.Bagagem;

import java.util.List;

public interface BagagemUseCase {
    Bagagem salvar(Bagagem bagagem);
    List<Bagagem> listar();
    Bagagem buscarPorId(Long id);
    Bagagem atualizar(Long id, Bagagem bagagem);
    void deletar(Long id);
}