package br.com.project.airport.comunicacao.adapter;

import br.com.project.airport.comunicacao.model.Informacao;
import br.com.project.airport.comunicacao.out.InformacaoRepositoryPort;
import br.com.project.airport.comunicacao.repository.InformacaoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InformacaoRepositoryAdapter implements InformacaoRepositoryPort {

    private final InformacaoJpaRepository jpaRepository;

    public InformacaoRepositoryAdapter(InformacaoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Informacao salvar(Informacao informacao) {
        return jpaRepository.save(informacao);
    }

    @Override
    public Optional<Informacao> buscarPorId(String id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Informacao> buscarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(String id) {
        jpaRepository.deleteById(id);
    }
}
