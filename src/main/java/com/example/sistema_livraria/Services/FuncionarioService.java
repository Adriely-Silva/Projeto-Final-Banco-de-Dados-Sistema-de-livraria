package com.example.sistema_livraria.Services;


import com.example.sistema_livraria.models.Funcionario;
import com.example.sistema_livraria.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Método para inserir um funcionário usando query nativa
    public void insertFuncionario(String nome, String email, long cpf, double salario, String senha) {
        funcionarioRepository.insertFuncionario(nome, email, cpf, salario, senha);
    }

    // Método para salvar um funcionário
    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Método para buscar todos os funcionários
    public List<Funcionario> findAllFuncionarios() {
        return funcionarioRepository.findAllFuncionarios();
    }

    // Método para buscar um funcionário por ID
    public Optional<Funcionario> findFuncionarioById(int idFunc) {
        return funcionarioRepository.findFuncionarioById(idFunc);
    }

    // Método para buscar um funcionário por CPF
    public Optional<Funcionario> findFuncionarioByCpf(long cpf) {
        return funcionarioRepository.findFuncionarioByCpf(cpf);
    }

    // Método para buscar funcionários com salário maior que um valor
    public List<Funcionario> findFuncionariosBySalarioGreaterThan(double salario) {
        return funcionarioRepository.findFuncionariosBySalarioGreaterThan(salario);
    }

    // Método para atualizar o salário de um funcionário
    public void updateSalarioById(int idFunc, double salario) {
        funcionarioRepository.updateSalarioById(idFunc, salario);
    }

    // Método para deletar um funcionário por ID
    public void deleteFuncionarioById(int idFunc) {
        funcionarioRepository.deleteFuncionarioById(idFunc);
    }
}