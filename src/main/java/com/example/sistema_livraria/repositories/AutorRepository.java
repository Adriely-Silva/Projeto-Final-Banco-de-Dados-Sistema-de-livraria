package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    // Consulta personalizada para buscar todos os autores
    @Query("SELECT a FROM Autor a")
    List<Autor> findAllAutores();

    // Consulta personalizada para buscar um autor por ID
    @Query("SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
    Optional<Autor> findAutorById(int idAutor);

    // Consulta personalizada para buscar autores por nome
    @Query("SELECT a FROM Autor a WHERE a.nomeAutor LIKE %:nomeAutor%")
    List<Autor> findAutoresByNome(String nomeAutor);
}
