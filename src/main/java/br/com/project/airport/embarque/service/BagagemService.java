package br.com.project.airport.embarque.service;

import br.com.project.airport.embarque.in.BagagemUseCase;
import br.com.project.airport.embarque.model.Bagagem;
import br.com.project.airport.embarque.out.BagagemRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BagagemService implements BagagemUseCase {

    private final BagagemRepositoryPort repository;

    public BagagemService(BagagemRepositoryPort repository) {
        this.repository = repository;
    }

    public Bagagem salvar(Bagagem bagagem) {
        return repository.salvar(bagagem);
    }

    public List<Bagagem> listar() {
        return repository.listar();
    }

    public Bagagem buscarPorId(Long id) {
        return repository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Bagagem não encontrada"));
    }

    public Bagagem atualizar(Long id, Bagagem novaBagagem) {
        Bagagem existente = buscarPorId(id);
        existente.setPeso(novaBagagem.getPeso());
        existente.setNome(novaBagagem.getNome());
        return repository.salvar(existente);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}