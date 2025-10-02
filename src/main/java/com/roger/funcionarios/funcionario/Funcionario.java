package com.roger.funcionarios.funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cargo;
    private LocalDate dataNascimento;

    private Funcionario() {}

    public Funcionario(String nome, String cargo, LocalDate dataNascimento) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
