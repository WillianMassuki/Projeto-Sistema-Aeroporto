package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Inspecao;
import br.com.project.airport.regulamentacao.out.InspecaoRepositoryPort;
import br.com.project.airport.regulamentacao.repository.InspecaoRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspecaoService implements InspecaoRepositoryPort {

    private final InspecaoRepositoryJpa inspecaoRepositoryJpa;

    public InspecaoService(InspecaoRepositoryJpa inspecaoRepositoryJpa) {
        this.inspecaoRepositoryJpa = inspecaoRepositoryJpa;
    }

    @Override
    public Inspecao salvar(Inspecao inspecao) {
        return inspecaoRepositoryJpa.save(inspecao);
    }

    @Override
    public Optional<Inspecao> buscarPorId(Long id) {
        return inspecaoRepositoryJpa.findById(id);
    }

    @Override
    public List<Inspecao> buscarTodas() {
        return inspecaoRepositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        inspecaoRepositoryJpa.deleteById(id);

    }
}
