package br.com.project.airport.embarque.adapter;

import br.com.project.airport.embarque.out.PortaoEmbarqueRepositoryPort;
import br.com.project.airport.embarque.repository.PortaoEmbarqueRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PortaoEmbarqueAdapter implements PortaoEmbarqueRepositoryPort {

    private final PortaoEmbarqueRepository portaoEmbarqueRepository;

    public PortaoEmbarqueAdapter(PortaoEmbarqueRepository portaoEmbarqueRepository) {
        this.portaoEmbarqueRepository = portaoEmbarqueRepository;
    }

    @Override
    public PortaoEmbarque salvar(PortaoEmbarque portao) {
        return portaoEmbarqueRepository.save(portao);
    }

    @Override
    public List<PortaoEmbarque> listar() {
        return List.of();
    }

    @Override
    public Optional<PortaoEmbarque> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {
        portaoEmbarqueRepository.deleteById(id);
    }
}
