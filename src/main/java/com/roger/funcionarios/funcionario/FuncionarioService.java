package com.roger.funcionarios.funcionario;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public Optional<Funcionario> get(Long id) {
        return repository.findById(id)/*.orElse(null)*/;
    }

    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario delete(Long id) {
        Funcionario funcionario = repository.findById(id).orElse(null);
        repository.delete(funcionario);
        return funcionario;
    }

    public Funcionario update(Long id, Funcionario newData) {
        return repository.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(newData.getNome());
                    funcionario.setCargo(newData.getCargo());
                    funcionario.setDataNascimento(newData.getDataNascimento());
                    return repository.save(funcionario);
                })
                .orElseThrow(() -> new RuntimeException("Funcionario not found"));
    }
}
