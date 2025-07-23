package br.com.project.airport.gestaofinanceira.service;

import br.com.project.airport.gestaofinanceira.in.DespesaUseCase;
import br.com.project.airport.gestaofinanceira.model.Despesa;
import br.com.project.airport.gestaofinanceira.out.DespesaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService implements DespesaUseCase {

    private final DespesaRepositoryPort repository;

    public DespesaService(DespesaRepositoryPort repository) {
        this.repository = repository;
    }

    public Despesa salvar(Despesa despesa) {
        return repository.salvar(despesa);
    }

    public List<Despesa> listar() {
        return repository.listar();
    }

    public Despesa buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
    }

    public Despesa atualizar(Long id, Despesa nova) {
        Despesa atual = buscarPorId(id);
        atual.setDescricao(nova.getDescricao());
        atual.setValor(nova.getValor());
        atual.setData(nova.getData());
        atual.setCategoria(nova.getCategoria());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}