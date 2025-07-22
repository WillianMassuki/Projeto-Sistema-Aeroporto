package br.com.project.airport.comunicacao.service;

import br.com.project.airport.comunicacao.in.MensagemUseCase;
import br.com.project.airport.comunicacao.model.Mensagem;
import br.com.project.airport.comunicacao.out.MensagemRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensagemService implements MensagemUseCase {

    private final MensagemRepositoryPort repository;

    public MensagemService(MensagemRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mensagem criar(Mensagem mensagem) {
        return repository.salvar(mensagem);
    }

    @Override
    public Optional<Mensagem> buscarPorId(String id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Mensagem> listar() {
        return repository.buscarTodos();
    }

    @Override
    public Mensagem atualizar(String id, Mensagem mensagem) {
        Optional<Mensagem> existente = repository.buscarPorId(id);
        if (existente.isPresent()) {
            Mensagem atualizada = existente.get();
            atualizada.setRemetente(mensagem.getRemetente());
            atualizada.setDestinatario(mensagem.getDestinatario());
            atualizada.setConteudo(mensagem.getConteudo());
            atualizada.setDataHora(mensagem.getDataHora());
            return repository.salvar(atualizada);
        } else {
            throw new RuntimeException("Mensagem não encontrada");
        }
    }

    @Override
    public void deletar(String id) {
        repository.deletarPorId(id);
    }
}
