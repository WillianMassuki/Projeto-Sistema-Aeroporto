package br.com.project.airport.embarque.service;

import br.com.project.airport.embarque.in.PortaoEmbarqueUseCase;
import br.com.project.airport.embarque.model.PortaoEmbarque;
import br.com.project.airport.embarque.out.PortaoEmbarqueRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaoEmbarqueService implements PortaoEmbarqueUseCase {

    private final PortaoEmbarqueRepositoryPort repository;

    public PortaoEmbarqueService(PortaoEmbarqueRepositoryPort repository) {
        this.repository = repository;
    }

    public PortaoEmbarque salvar(PortaoEmbarque portao) {
        return repository.salvar(portao);
    }

    public List<PortaoEmbarque> listar() {
        return repository.listar();
    }

    public PortaoEmbarque buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Portão não encontrado"));
    }

    public PortaoEmbarque atualizar(Long id, PortaoEmbarque novo) {
        PortaoEmbarque atual = buscarPorId(id);
        atual.setIdPortao(novo.getIdPortao());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}