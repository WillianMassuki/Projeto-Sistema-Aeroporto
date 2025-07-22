package br.com.project.airport.embarque.adapter;

import br.com.project.airport.embarque.model.Bagagem;
import br.com.project.airport.embarque.out.BagagemRepositoryPort;
import br.com.project.airport.embarque.repository.BagagemJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BagagemJpaRepositoryAdapter implements BagagemRepositoryPort {

    private final BagagemJpaRepository jpaRepository;

    public BagagemJpaRepositoryAdapter(BagagemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Bagagem salvar(Bagagem bagagem) {
        return jpaRepository.save(bagagem);
    }

    public List<Bagagem> listar() {
        return jpaRepository.findAll();
    }

    public Optional<Bagagem> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }
}