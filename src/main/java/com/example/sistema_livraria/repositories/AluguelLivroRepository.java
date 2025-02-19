package com.example.sistema_livraria.repositories;


import com.example.sistema_livraria.models.AluguelLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelLivroRepository extends JpaRepository<AluguelLivro, Integer> {

    // Consulta personalizada para buscar todas as associações Aluguel-Livro
    @Query("SELECT al FROM AluguelLivro al")
    List<AluguelLivro> findAllAluguelLivros();

    // Consulta personalizada para buscar uma associação Aluguel-Livro por ID do Aluguel
    @Query("SELECT al FROM AluguelLivro al WHERE al.idAluguel = :idAluguel")
    Optional<AluguelLivro> findAluguelLivroById(int idAluguel);

    // Consulta personalizada para buscar associações Aluguel-Livro por data de devolução
    @Query("SELECT al FROM AluguelLivro al WHERE al.dataDevolucao = :dataDevolucao")
    List<AluguelLivro> findAluguelLivrosByDataDevolucao(LocalDateTime dataDevolucao);
}