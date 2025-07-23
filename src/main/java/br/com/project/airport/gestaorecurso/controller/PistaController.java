package br.com.project.airport.gestaorecurso.controller;

import br.com.project.airport.gestaorecurso.in.PistaServicePort;
import br.com.project.airport.gestaorecurso.model.Pista;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pistas")
public class PistaController {

    private final PistaServicePort pistaService;

    public PistaController(PistaServicePort pistaService) {
        this.pistaService = pistaService;
    }

    @PostMapping
    public ResponseEntity<Pista> criarPista(@RequestBody Pista pista) {
        return ResponseEntity.ok(pistaService.criarPista(pista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pista> buscarPorId(@PathVariable Long id) {
        return pistaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Pista>> listarTodas() {
        return ResponseEntity.ok(pistaService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pista> atualizar(@PathVariable Long id, @RequestBody Pista pista) {
        return ResponseEntity.ok(pistaService.atualizarPista(id, pista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pistaService.deletarPista(id);
        return ResponseEntity.noContent().build();
    }
}