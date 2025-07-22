package br.com.project.airport.comunicacao.controller;

import br.com.project.airport.comunicacao.in.MensagemUseCase;
import br.com.project.airport.comunicacao.model.Mensagem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

    private final MensagemUseCase mensagemUseCase;

    public MensagemController(MensagemUseCase mensagemUseCase) {
        this.mensagemUseCase = mensagemUseCase;
    }

    @PostMapping
    public ResponseEntity<Mensagem> criar(@RequestBody Mensagem mensagem) {
        return ResponseEntity.ok(mensagemUseCase.criar(mensagem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable String id) {
        return mensagemUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Mensagem>> listar() {
        return ResponseEntity.ok(mensagemUseCase.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensagem> atualizar(@PathVariable String id, @RequestBody Mensagem mensagem) {
        try {
            Mensagem atualizada = mensagemUseCase.atualizar(id, mensagem);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        mensagemUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}