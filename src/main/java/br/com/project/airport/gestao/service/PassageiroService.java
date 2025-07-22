package br.com.project.airport.gestao.service;

import br.com.project.airport.gestao.in.PassageiroUseCase;
import br.com.project.airport.gestao.model.Passageiro;
import br.com.project.airport.gestao.out.PassageiroRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageiroService implements PassageiroUseCase {

    private final PassageiroRepositoryPort repository;

    public PassageiroService(PassageiroRepositoryPort repository) {
        this.repository = repository;
    }

    public Passageiro salvar(Passageiro passageiro) {
        return repository.salvar(passageiro);
    }

    public List<Passageiro> listar() {
        return repository.listar();
    }

    public Passageiro buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    
    public Passageiro atualizar(Long id, Passageiro novo) {
        Passageiro atual = buscarPorId(id);
        atual.setNome(novo.getNome());
        atual.setDocumento(novo.getDocumento());
        atual.setNumeroCartao(novo.getNumeroCartao());
        return repository.salvar(atual);
    }
    

    public void deletar(Long id) {
        repository.deletar(id);
    }
}