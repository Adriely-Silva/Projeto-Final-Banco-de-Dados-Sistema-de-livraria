package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {


    // Query nativa para INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Funcionario (Nome_Func, Email, CPF, Salário, Senha) VALUES (:nome, :email, :cpf, :salario, :senha)",
            nativeQuery = true)
    void insertFuncionario(String nome, String email, long cpf, double salario, String senha);



    // Consulta personalizada para buscar todos os funcionários
    @Query("SELECT f FROM Funcionario f")
    List<Funcionario> findAllFuncionarios();

    // Consulta personalizada para buscar um funcionário por ID
    @Query("SELECT f FROM Funcionario f WHERE f.idFunc = :idFunc")
    Optional<Funcionario> findFuncionarioById(int idFunc);

    // Consulta personalizada para buscar um funcionário por CPF
    @Query("SELECT f FROM Funcionario f WHERE f.cpf = :cpf")
    Optional<Funcionario> findFuncionarioByCpf(long cpf);

    // Consulta personalizada para buscar funcionários com salário maior que um valor
    @Query("SELECT f FROM Funcionario f WHERE f.salario > :salario")
    List<Funcionario> findFuncionariosBySalarioGreaterThan(double salario);

    // Consulta personalizada para atualizar o salário de um funcionário
    @Modifying
    @Transactional
    @Query("UPDATE Funcionario f SET f.salario = :salario WHERE f.idFunc = :idFunc")
    void updateSalarioById(int idFunc, double salario);

    // Consulta personalizada para deletar um funcionário por ID
    @Query("DELETE FROM Funcionario f WHERE f.idFunc = :idFunc")
    void deleteFuncionarioById(int idFunc);
}