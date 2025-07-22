package br.com.project.airport.embarque.out;

import br.com.project.airport.embarque.model.Bagagem;

import java.util.List;
import java.util.Optional;

public interface BagagemRepositoryPort {
    Bagagem salvar(Bagagem bagagem);
    List<Bagagem> listar();
    Optional<Bagagem> buscarPorId(Long id);
    void deletar(Long id);
}