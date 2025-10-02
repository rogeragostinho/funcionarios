package com.roger.funcionarios;

import com.roger.funcionarios.funcionario.Funcionario;
import com.roger.funcionarios.funcionario.FuncionarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class FuncionariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionariosApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(FuncionarioRepository repository) {
		return args -> {

			repository.save(new Funcionario("Róger Hugo", "Engenheiro de Software", LocalDate.of(2004, 06, 05)));
			repository.save(new Funcionario("Mirela", "Engenheira de Petróleo", LocalDate.of(2014, 12, 26)));
			repository.save(new Funcionario("Adão Vuenda", "Humorista", LocalDate.now()));
			//repository.save(new Funcionario("", "", LocalDate.now()));
		};
	}
}
