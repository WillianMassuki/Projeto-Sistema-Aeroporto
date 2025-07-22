package br.com.project.airport.comunicacao.controller;

import br.com.project.airport.comunicacao.in.InformacaoUseCase;
import br.com.project.airport.comunicacao.model.Informacao;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informacoes")
public class InformacaoController {

    private final InformacaoUseCase informacaoUseCase;

    public InformacaoController(InformacaoUseCase informacaoUseCase) {
        this.informacaoUseCase = informacaoUseCase;
    }

    @PostMapping
    @Operation(summary = "Adicionar uma informação nova")
    public ResponseEntity<Informacao> criar(@RequestBody Informacao informacao) {
        return ResponseEntity.ok(informacaoUseCase.criar(informacao));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Filtrar a informação pelo codigo")
    public ResponseEntity<Informacao> buscarPorId(@PathVariable String id) {
        return informacaoUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todas as informaçoes")
    public ResponseEntity<List<Informacao>> listar() {
        return ResponseEntity.ok(informacaoUseCase.listar());
    }

    @PutMapping("/{id}")
    @Operation(summary = "atualizar os dados das informações")
    public ResponseEntity<Informacao> atualizar(@PathVariable String id, @RequestBody Informacao informacao) {
        try {
            Informacao atualizada = informacaoUseCase.atualizar(id, informacao);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deletar alguma informação")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        informacaoUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}