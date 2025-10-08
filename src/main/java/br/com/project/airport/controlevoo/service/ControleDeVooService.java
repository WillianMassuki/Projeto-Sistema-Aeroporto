package br.com.project.airport.controlevoo.service;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.port.ControleDeVooRepositoryPort;
import br.com.project.airport.controlevoo.port.ControleDeVooServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControleDeVooService implements ControleDeVooServicePort {

    private final ControleDeVooRepositoryPort repositoryPort;

    public ControleDeVooService(ControleDeVooRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ControleDeVoo criarControle(ControleDeVoo controle) {
        return repositoryPort.save(controle);
    }

    @Override
    public ControleDeVoo atualizarControle(Long id, ControleDeVoo controle) {
        ControleDeVoo existente = repositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Controle não encontrado"));
        existente.setStatus(controle.getStatus());
        existente.setControlador(controle.getControlador());
        existente.setTorreDeControle(controle.getTorreDeControle());
        return repositoryPort.save(existente);
    }

    @Override
    public ControleDeVoo buscarPorId(Long id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Controle não encontrado"));
    }

    @Override
    public List<ControleDeVoo> listarTodos() {
        return repositoryPort.findAll();
    }

    @Override
    public void deletar(Long id) {
        repositoryPort.deleteById(id);
    }
}