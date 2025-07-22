package br.com.project.airport.gestao.in;

import br.com.project.airport.gestao.model.Passageiro;

import java.util.List;

public interface PassageiroUseCase {
    Passageiro salvar(Passageiro passageiro);

    List<Passageiro> listar();
    
    Passageiro buscarPorId(Long id);
     
    Passageiro atualizar(Long id, Passageiro passageiro);

    void deletar(Long id);


}