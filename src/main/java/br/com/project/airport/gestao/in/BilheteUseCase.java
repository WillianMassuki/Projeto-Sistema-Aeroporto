package br.com.project.airport.gestao.in;

import br.com.project.airport.gestao.model.Bilhete;

import java.util.List;

public interface BilheteUseCase {

    Bilhete salvar(Bilhete bilhete);

    List<Bilhete> listar();

    Bilhete buscarPorId(Long id);

    Bilhete atualizar(Long id, Bilhete bilhete);

    void deletar(Long id);
}
