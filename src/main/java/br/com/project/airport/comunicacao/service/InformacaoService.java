package br.com.project.airport.comunicacao.service;

import br.com.project.airport.comunicacao.in.InformacaoUseCase;
import br.com.project.airport.comunicacao.model.Informacao;
import br.com.project.airport.comunicacao.out.InformacaoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacaoService implements InformacaoUseCase {

    private final InformacaoRepositoryPort repository;

    public InformacaoService(InformacaoRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public Informacao criar(Informacao informacao) {
        return repository.salvar(informacao);
    }

    @Override
    public Optional<Informacao> buscarPorId(String id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Informacao> listar() {
        return repository.buscarTodos();
    }

    @Override
    public Informacao atualizar(String id, Informacao informacao) {
        Optional<Informacao> existente = repository.buscarPorId(id);
        if (existente.isPresent()) {
            Informacao atualizada = existente.get();
            atualizada.setTipo(informacao.getTipo());
            atualizada.setConteudo(informacao.getConteudo());
            atualizada.setValidade(informacao.getValidade());
            return repository.salvar(atualizada);
        } else {
            throw new RuntimeException("Informação não encontrada");
        }
    }

    @Override
    public void deletar(String id) {
        repository.deletarPorId(id);
    }
}