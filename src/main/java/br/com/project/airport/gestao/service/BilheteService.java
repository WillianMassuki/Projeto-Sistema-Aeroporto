package br.com.project.airport.gestao.service;

import br.com.project.airport.gestao.in.BilheteUseCase;
import br.com.project.airport.gestao.model.Bilhete;
import br.com.project.airport.gestao.out.BilheteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilheteService implements BilheteUseCase {

    private final BilheteRepositoryPort repository;

    public BilheteService(BilheteRepositoryPort repository) {
        this.repository = repository;
    }

    public Bilhete salvar(Bilhete bilhete) {
        return repository.salvar(bilhete);
    }

    public List<Bilhete> listar() {
        return repository.listar();
    }

    public Bilhete buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Bilhete não encontrado"));
    }

    public Bilhete atualizar(Long id, Bilhete novo) {
        Bilhete atual = buscarPorId(id);
        atual.setAssento(novo.getAssento());
        atual.setBagagem(novo.getBagagem());
        atual.setNumero(novo.getNumero());
        atual.setPassageiro(novo.getPassageiro());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}
