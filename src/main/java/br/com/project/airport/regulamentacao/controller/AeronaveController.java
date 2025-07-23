package br.com.project.airport.regulamentacao.controller;

import br.com.project.airport.regulamentacao.model.Aeronave;
import br.com.project.airport.regulamentacao.service.AeronaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

    private final AeronaveService aeronaveService;

    public AeronaveController(AeronaveService aeronaveService) {
        this.aeronaveService = aeronaveService;
    }

    @PostMapping
    public ResponseEntity<Aeronave> criarPista(@RequestBody Aeronave aeronave) {
        return ResponseEntity.ok(aeronaveService.salvar(aeronave));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeronave> buscarPorId(@PathVariable Long id) {
        return aeronaveService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Aeronave>> listarTodas() {
        return ResponseEntity.ok(aeronaveService.buscarTodas());
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Pista> atualizar(@PathVariable Long id, @RequestBody Pista pista) {
        return ResponseEntity.ok(aeronaveService.
    }

     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        aeronaveService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }


}
