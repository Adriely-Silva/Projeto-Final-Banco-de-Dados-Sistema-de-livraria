package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.LivrosAlugados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosAlugadosRepository extends JpaRepository<LivrosAlugados, Integer> {

    // Consulta personalizada para buscar todas as associações Livros-Alugados
    @Query("SELECT la FROM LivrosAlugados la")
    List<LivrosAlugados> findAllLivrosAlugados();

    // Consulta personalizada para buscar associações por ID do Aluguel_Livro
    @Query("SELECT la FROM LivrosAlugados la WHERE la.aluguelLivro.idAluguel = :idAluguel")
    List<LivrosAlugados> findByAluguelLivroId(int idAluguel);

    // Consulta personalizada para buscar associações por ID do Livro
    @Query("SELECT la FROM LivrosAlugados la WHERE la.livro.idLivro = :idLivro")
    List<LivrosAlugados> findByLivroId(int idLivro);
}