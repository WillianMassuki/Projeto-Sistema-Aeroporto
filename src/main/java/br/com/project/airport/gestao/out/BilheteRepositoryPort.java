package br.com.project.airport.gestao.out;

import br.com.project.airport.gestao.model.Bilhete;

import java.util.List;
import java.util.Optional;

public interface BilheteRepositoryPort {
    Bilhete salvar(Bilhete bilhete);
    List<Bilhete> listar();
    Optional<Bilhete> buscarPorId(Long id);
    void deletar(Long id);
}
