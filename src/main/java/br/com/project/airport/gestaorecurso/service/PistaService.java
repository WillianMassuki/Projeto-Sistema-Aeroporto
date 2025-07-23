package br.com.project.airport.gestaorecurso.service;

import br.com.project.airport.gestaorecurso.in.PistaServicePort;
import br.com.project.airport.gestaorecurso.model.Pista;
import br.com.project.airport.gestaorecurso.out.PistaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PistaService  implements PistaServicePort {


    private final PistaRepositoryPort pistaRepositoryPort;

    public PistaService(PistaRepositoryPort pistaRepositoryPort) {
        this.pistaRepositoryPort = pistaRepositoryPort;
    }

    @Override
    public Pista criarPista(Pista pista) {
        return pistaRepositoryPort.salvar(pista);
    }

    @Override
    public Optional<Pista> buscarPorId(Long id) {
        return pistaRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Pista> listarTodas() {
        return pistaRepositoryPort.buscarTodas();
    }

    @Override
    public Pista atualizarPista(Long id, Pista pistaAtualizada) {
        Optional<Pista> existente = pistaRepositoryPort.buscarPorId(id);
        if (existente.isEmpty()) {
            throw new RuntimeException("Pista não encontrada com id: " + id);
        }

        Pista pista = existente.get();
        pista.setStatus(pistaAtualizada.getStatus());

        return pistaRepositoryPort.salvar(pista);
    }

    @Override
    public void deletarPista(Long id) {
        pistaRepositoryPort.deletarPorId(id);
    }

   public String agendarUso()
   {

       return "";
   }
}
