package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Aeronave;
import br.com.project.airport.regulamentacao.out.AeronaveRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeronaveService implements AeronaveRepositoryPort {

    private final AeronaveRepositoryPort aeronaveRepositoryPort;

    public AeronaveService(AeronaveRepositoryPort aeronaveRepositoryPort) {
        this.aeronaveRepositoryPort = aeronaveRepositoryPort;
    }


    @Override
    public Aeronave salvar(Aeronave aeronave) {
        return aeronaveRepositoryPort.salvar(aeronave);
    }

    @Override
    public Optional<Aeronave> buscarPorId(Long id) {
        return aeronaveRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Aeronave> buscarTodas() {
        return aeronaveRepositoryPort.buscarTodas();
    }

    @Override
    public void deletarPorId(Long id) {

        aeronaveRepositoryPort.deletarPorId(id);

    }



    public String enviarDados(){
        return "nada de dados";
    }

    public String verificarDisponibilidade()
    {

        return "";
    }
}
