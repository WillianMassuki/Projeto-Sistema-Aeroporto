package br.com.project.airport.gestao.out;

import br.com.project.airport.gestao.model.Passageiro;

import java.util.List;

public interface PassageiroRepositoryPort {
    Passageiro salvar(Passageiro passageiro);
    List<Passageiro> listar();
   Passageiro buscarPorId(Long id);
    void deletar(Long id);
}