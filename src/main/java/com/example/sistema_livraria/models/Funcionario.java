package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Func")
    private int idFunc;

    @Column(name = "Nome_Func", nullable = false)
    private String nomeFunc;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "CPF", nullable = false)
    private long cpf;

    @Column(name = "Salário", nullable = false)
    private double salario;

    @Column(name = "Senha", nullable = false)
    private String senha;

    // Construtor padrão (obrigatório para JPA)
    public Funcionario() {}

    // Construtor com parâmetros
    public Funcionario(String nomeFunc, String email, long cpf, double salario, String senha) {
        this.nomeFunc = nomeFunc;
        this.email = email;
        this.cpf = cpf;
        this.salario = salario;
        this.senha = senha;
    }

    // Getters e Setters
    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}