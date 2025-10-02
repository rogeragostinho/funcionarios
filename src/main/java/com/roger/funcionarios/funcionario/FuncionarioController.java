package com.roger.funcionarios.funcionario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> get(@PathVariable Long id) {
        return service.get(id)
                .map(funcionario -> ResponseEntity.ok(funcionario))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return service.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public Funcionario delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PatchMapping("/{id}")
    public Funcionario update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return service.update(id, funcionario);
    }
}
