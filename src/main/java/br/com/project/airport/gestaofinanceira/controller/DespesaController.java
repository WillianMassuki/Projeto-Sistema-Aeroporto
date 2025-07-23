package br.com.project.airport.gestaofinanceira.controller;

import br.com.project.airport.gestaofinanceira.model.Despesa;
import br.com.project.airport.gestaofinanceira.service.DespesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaUseCase;

    public DespesaController(DespesaService despesaUseCase) {
        this.despesaUseCase = despesaUseCase;
    }


    @PostMapping
    public Despesa salvar(@RequestBody Despesa despesa) {
        return despesaUseCase.salvar(despesa);

    }

    @GetMapping
    public List<Despesa> listar() {
        return despesaUseCase.listar();
    }

    @GetMapping("/{id}")
    public Despesa buscar(@PathVariable Long id) {
        return despesaUseCase.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        despesaUseCase.deletar(id);
    }
}
