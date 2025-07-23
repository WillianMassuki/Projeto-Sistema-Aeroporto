package br.com.project.airport.regulamentacao.controller;

import br.com.project.airport.regulamentacao.model.Auditor;
import br.com.project.airport.regulamentacao.service.AuditorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/auditor")
public class AuditorController {

    private final AuditorService auditorService;

    public AuditorController(AuditorService auditorService) {
        this.auditorService = auditorService;
    }


    @PostMapping
    public ResponseEntity<Auditor> adicionarAuditor(@RequestBody Auditor auditor) {
        return ResponseEntity.ok(auditorService.salvar(auditor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditor> buscarPorId(@PathVariable Long id) {
        return auditorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Auditor>> listarTodas() {
        return ResponseEntity.ok(auditorService.buscarTodas());
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Auditor> atualizar(@PathVariable Long id, @RequestBody Auditor auditor) {
        return ResponseEntity.ok(auditorService.
    }

     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        auditorService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}