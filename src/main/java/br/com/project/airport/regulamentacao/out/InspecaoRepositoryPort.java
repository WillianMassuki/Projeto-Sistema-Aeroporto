package br.com.project.airport.regulamentacao.out;

import br.com.project.airport.regulamentacao.model.Inspecao;

import java.util.List;
import java.util.Optional;

public interface InspecaoRepositoryPort {
    Inspecao salvar(Inspecao inspecao);
    Optional<Inspecao> buscarPorId(Long id);
    List<Inspecao> buscarTodas();
    void deletarPorId(Long id);
}
