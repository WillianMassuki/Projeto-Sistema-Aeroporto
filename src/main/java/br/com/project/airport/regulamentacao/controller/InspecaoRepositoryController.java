package br.com.project.airport.regulamentacao.controller;

import br.com.project.airport.regulamentacao.model.Inspecao;
import br.com.project.airport.regulamentacao.service.InspecaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspecao")
public class InspecaoRepositoryController {

    private final InspecaoService inspecaoService;

    public InspecaoRepositoryController(InspecaoService inspecaoService) {
        this.inspecaoService = inspecaoService;
    }

    @PostMapping
    public ResponseEntity<Inspecao> salvarDadosInspecao(@RequestBody Inspecao inspecao) {
        return ResponseEntity.ok(inspecaoService.salvar(inspecao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inspecao> buscarDadosPorId(@PathVariable Long id) {
        return inspecaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Inspecao>> listarTodas() {
        return ResponseEntity.ok(inspecaoService.buscarTodas());
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Inspecao> atualizar(@PathVariable Long id, @RequestBody Inspecao inspecao) {
        return ResponseEntity.ok(inspecaoService.
    }

     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        inspecaoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}



