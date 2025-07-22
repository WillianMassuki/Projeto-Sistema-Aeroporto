package br.com.project.airport.comunicacao.adapter;

import br.com.project.airport.comunicacao.model.Mensagem;
import br.com.project.airport.comunicacao.out.MensagemRepositoryPort;
import br.com.project.airport.comunicacao.repository.MensagemJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MensagemRepositoryAdapter implements MensagemRepositoryPort {

    private final MensagemJpaRepository jpaRepository;

    public MensagemRepositoryAdapter(MensagemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Mensagem salvar(Mensagem mensagem) {
        return jpaRepository.save(mensagem);
    }

    @Override
    public Optional<Mensagem> buscarPorId(String id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Mensagem> buscarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(String id) {
        jpaRepository.deleteById(id);
    }
}