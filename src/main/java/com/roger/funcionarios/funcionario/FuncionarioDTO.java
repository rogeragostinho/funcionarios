package com.roger.funcionarios.funcionario;

import java.time.LocalDate;

public record FuncionarioDTO(Long id, String nome, String cargo, LocalDate dataNascimento) {
}
