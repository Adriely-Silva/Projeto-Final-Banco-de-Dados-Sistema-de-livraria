package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.EdicaoLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdicaoLivroRepository extends JpaRepository<EdicaoLivro, Integer> {

    // Consulta personalizada para buscar todas as associações Edicao-Livro
    @Query("SELECT el FROM EdicaoLivro el")
    List<EdicaoLivro> findAllEdicaoLivro();

    // Consulta personalizada para buscar associações por ID da Edicao
    @Query("SELECT el FROM EdicaoLivro el WHERE el.edicao.idEdicao = :idEdicao")
    List<EdicaoLivro> findByEdicaoId(int idEdicao);

    // Consulta personalizada para buscar associações por ID do Livro
    @Query("SELECT el FROM EdicaoLivro el WHERE el.livro.idLivro = :idLivro")
    List<EdicaoLivro> findByLivroId(int idLivro);
}