package br.com.project.airport.gestaorecurso.service;

import br.com.project.airport.gestaorecurso.in.VeiculoApoioUseCase;
import br.com.project.airport.gestaorecurso.model.VeiculoApoio;
import br.com.project.airport.gestaorecurso.out.VeiculoApoioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoApoioService implements VeiculoApoioUseCase {

    private final VeiculoApoioRepository repository;

    public VeiculoApoioService(VeiculoApoioRepository repository) {
        this.repository = repository;
    }

    @Override
    public VeiculoApoio salvar(VeiculoApoio veiculo) {
        return repository.save(veiculo);
    }

    @Override
    public Optional<VeiculoApoio> buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa);
    }

    @Override
    public List<VeiculoApoio> listarTodos() {
        return repository.findAll();
    }

    @Override
    public VeiculoApoio atualizar(String placa, VeiculoApoio veiculo) {
        Optional<VeiculoApoio> existente = repository.findByPlaca(placa);
        if (existente.isPresent()) {
            veiculo.setPlaca(placa);
            return repository.save(veiculo);
        }
        throw new RuntimeException("Veículo não encontrado");
    }

    @Override
    public void deletar(String placa) {
        repository.deleteByPlaca(placa);
    }

    public Boolean ativar() {
        return true;
    }


    public Boolean desativar() {
        return false;
    }
}