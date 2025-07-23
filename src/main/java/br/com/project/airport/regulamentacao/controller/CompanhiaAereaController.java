package br.com.project.airport.regulamentacao.controller;

import br.com.project.airport.regulamentacao.model.CompanhiaAerea;
import br.com.project.airport.regulamentacao.service.CompanhiaAereaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companhia")
public class CompanhiaAereaController {

    private final CompanhiaAereaService companhiaAereaService;

    public CompanhiaAereaController(CompanhiaAereaService companhiaAereaService) {
        this.companhiaAereaService = companhiaAereaService;
    }


    @PostMapping
    public ResponseEntity<CompanhiaAerea> adicionarCompanhiaArea(@RequestBody CompanhiaAerea companhiaAerea) {
        return ResponseEntity.ok(companhiaAereaService.criarCompanhiaAerea(companhiaAerea));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanhiaAerea> buscarCompanhiaAereaPorCodigo(@PathVariable Long id) {
        return companhiaAereaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CompanhiaAerea>> listarTodas() {
        return ResponseEntity.ok(companhiaAereaService.listarTodasCompanhias());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanhiaAerea> atualizar(@PathVariable Long id, @RequestBody CompanhiaAerea companhiaAerea) {
        return ResponseEntity.ok(companhiaAereaService.atualizarCompanhiaAerea(id, companhiaAerea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        companhiaAereaService.deletarCompanhia(id);
        return ResponseEntity.noContent().build();
    }
}
