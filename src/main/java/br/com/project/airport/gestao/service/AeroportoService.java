package br.com.project.airport.gestao.service;

import br.com.project.airport.gestao.in.AeroportoUseCase;
import br.com.project.airport.gestao.model.Aeroporto;
import br.com.project.airport.gestao.out.AeroportoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportoService implements AeroportoUseCase {

    private final AeroportoRepositoryPort repository;

    public AeroportoService(AeroportoRepositoryPort repository) {
        this.repository = repository;
    }

    public Aeroporto salvar(Aeroporto aeroporto) {
        return repository.salvar(aeroporto);
    }

    public List<Aeroporto> listar() {
        return repository.listar();
    }

    public Aeroporto buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aeroporto não encontrado"));
    }

    public Aeroporto atualizar(Long id, Aeroporto novo) {
        Aeroporto atual = buscarPorId(id);
        atual.setNome(novo.getNome());
        atual.setCodigo(novo.getCodigo());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public void gerenciarFuncionarios() {

    }
}
