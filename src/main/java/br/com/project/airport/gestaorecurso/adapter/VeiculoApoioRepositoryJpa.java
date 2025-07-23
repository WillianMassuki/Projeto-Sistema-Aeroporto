package br.com.project.airport.gestaorecurso.adapter;

import br.com.project.airport.gestaorecurso.model.VeiculoApoio;
import br.com.project.airport.gestaorecurso.out.VeiculoApoioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VeiculoApoioRepositoryJpa implements VeiculoApoioRepository {

    private final VeiculoApoioRepositoryJpa veiculoApoioRepositoryJpa;

    public VeiculoApoioRepositoryJpa(VeiculoApoioRepositoryJpa veiculoApoioRepositoryJpa) {
        this.veiculoApoioRepositoryJpa = veiculoApoioRepositoryJpa;
    }


    @Override
    public VeiculoApoio save(VeiculoApoio veiculo) {
        return  veiculoApoioRepositoryJpa.save(veiculo);
    }

    @Override
    public Optional<VeiculoApoio> findByPlaca(String placa) {
        return veiculoApoioRepositoryJpa.findByPlaca(placa);
    }

    @Override
    public List<VeiculoApoio> findAll() {
        return veiculoApoioRepositoryJpa.findAll();
    }

    @Override
    public void deleteByPlaca(String placa) {
      veiculoApoioRepositoryJpa.deleteByPlaca(placa);
    }
}