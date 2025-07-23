package br.com.project.airport.gestaorecurso.in;

import br.com.project.airport.gestaorecurso.model.VeiculoApoio;

import java.util.List;
import java.util.Optional;

public interface VeiculoApoioUseCase {
    VeiculoApoio salvar(VeiculoApoio veiculo);
    Optional<VeiculoApoio> buscarPorPlaca(String placa);
    List<VeiculoApoio> listarTodos();
    VeiculoApoio atualizar(String placa, VeiculoApoio veiculo);
    void deletar(String placa);
}