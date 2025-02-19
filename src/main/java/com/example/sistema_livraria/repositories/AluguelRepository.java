package com.example.sistema_livraria.repositories;


import com.example.sistema_livraria.models.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {

    // Consulta personalizada para buscar todos os aluguéis
    @Query("SELECT a FROM Aluguel a")
    List<Aluguel> findAllAlugueis();

    // Consulta personalizada para buscar um aluguel por ID
    @Query("SELECT a FROM Aluguel a WHERE a.idAluguel = :idAluguel")
    Optional<Aluguel> findAluguelById(int idAluguel);

    // Consulta personalizada para buscar aluguéis por data
    @Query("SELECT a FROM Aluguel a WHERE a.data = :data")
    List<Aluguel> findAlugueisByData(LocalDateTime data);

    // Consulta personalizada para buscar aluguéis com valor maior que um valor
    @Query("SELECT a FROM Aluguel a WHERE a.valor > :valor")
    List<Aluguel> findAlugueisByValorGreaterThan(double valor);
}