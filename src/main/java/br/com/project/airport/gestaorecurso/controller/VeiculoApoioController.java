package br.com.project.airport.gestaorecurso.controller;

import br.com.project.airport.gestaorecurso.in.VeiculoApoioUseCase;
import br.com.project.airport.gestaorecurso.model.VeiculoApoio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoApoioController {

    private final VeiculoApoioUseCase useCase;

    public VeiculoApoioController(VeiculoApoioUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<VeiculoApoio> criar(@RequestBody VeiculoApoio veiculo) {
        return ResponseEntity.ok(useCase.salvar(veiculo));
    }

    @GetMapping
    public List<VeiculoApoio> listar() {
        return useCase.listarTodos();
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoApoio> buscar(@PathVariable String placa) {
        return useCase.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{placa}")
    public ResponseEntity<VeiculoApoio> atualizar(@PathVariable String placa, @RequestBody VeiculoApoio veiculo) {
        return ResponseEntity.ok(useCase.atualizar(placa, veiculo));
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletar(@PathVariable String placa) {
        useCase.deletar(placa);
        return ResponseEntity.noContent().build();
    }
}