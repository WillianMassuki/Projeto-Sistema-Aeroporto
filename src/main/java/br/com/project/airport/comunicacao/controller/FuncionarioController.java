package br.com.project.airport.comunicacao.controller;

import br.com.project.airport.comunicacao.in.FuncionarioUseCase;
import br.com.project.airport.comunicacao.model.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioUseCase funcionarioUseCase;

    public FuncionarioController(FuncionarioUseCase funcionarioUseCase) {
        this.funcionarioUseCase = funcionarioUseCase;
    }

    @PostMapping
    @Operation(summary = "Criação do cadastro do Funcionario")
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioUseCase.criar(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.ok(funcionarioUseCase.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        try {
            Funcionario atualizado = funcionarioUseCase.atualizar(id, funcionario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
