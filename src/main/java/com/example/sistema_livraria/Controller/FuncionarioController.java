package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.FuncionarioService;
import com.example.sistema_livraria.models.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Endpoint para inserir um funcionário usando query nativa
    @PostMapping("/insert")
    public void insertFuncionario(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam long cpf,
            @RequestParam double salario,
            @RequestParam String senha
    ) {
        funcionarioService.insertFuncionario(nome, email, cpf, salario, senha);
    }

    // Endpoint para salvar um funcionário
    @PostMapping
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.saveFuncionario(funcionario);
    }

    // Endpoint para buscar todos os funcionários
    @GetMapping
    public List<Funcionario> findAllFuncionarios() {
        return funcionarioService.findAllFuncionarios();
    }

    // Endpoint para buscar um funcionário por ID
    @GetMapping("/{idFunc}")
    public Optional<Funcionario> findFuncionarioById(@PathVariable int idFunc) {
        return funcionarioService.findFuncionarioById(idFunc);
    }

    // Endpoint para buscar um funcionário por CPF
    @GetMapping("/cpf/{cpf}")
    public Optional<Funcionario> findFuncionarioByCpf(@PathVariable long cpf) {
        return funcionarioService.findFuncionarioByCpf(cpf);
    }

    // Endpoint para buscar funcionários com salário maior que um valor
    @GetMapping("/salario/{salario}")
    public List<Funcionario> findFuncionariosBySalarioGreaterThan(@PathVariable double salario) {
        return funcionarioService.findFuncionariosBySalarioGreaterThan(salario);
    }

    // Endpoint para atualizar o salário de um funcionário
    @Modifying
    @Transactional
    @PutMapping("/{idFunc}/salario")
    public void updateSalarioById(@PathVariable int idFunc, @RequestParam double salario) {
        funcionarioService.updateSalarioById(idFunc, salario);
    }

    // Endpoint para deletar um funcionário por ID
    @Modifying
    @Transactional
    @DeleteMapping("/{idFunc}")
    public void deleteFuncionarioById(@PathVariable int idFunc) {
        funcionarioService.deleteFuncionarioById(idFunc);
    }
}