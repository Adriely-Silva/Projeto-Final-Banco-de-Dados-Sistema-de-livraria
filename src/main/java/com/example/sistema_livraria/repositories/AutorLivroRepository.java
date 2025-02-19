package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.AutorLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorLivroRepository extends JpaRepository<AutorLivro, Integer> {

    // Consulta personalizada para buscar todas as associações Autor-Livro
    @Query("SELECT al FROM AutorLivro al")
    List<AutorLivro> findAllAutorLivro();

    // Consulta personalizada para buscar associações por ID do Autor
    @Query("SELECT al FROM AutorLivro al WHERE al.autor.idAutor = :idAutor")
    List<AutorLivro> findByAutorId(int idAutor);

    // Consulta personalizada para buscar associações por ID do Livro
    @Query("SELECT al FROM AutorLivro al WHERE al.livro.idLivro = :idLivro")
    List<AutorLivro> findByLivroId(int idLivro);
}