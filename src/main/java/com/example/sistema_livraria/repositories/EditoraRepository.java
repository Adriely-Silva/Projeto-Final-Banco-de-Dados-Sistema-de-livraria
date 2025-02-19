package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer> {

    // Consulta personalizada para buscar todas as editoras
    @Query("SELECT e FROM Editora e")
    List<Editora> findAllEditoras();

    // Consulta personalizada para buscar uma editora por ID
    @Query("SELECT e FROM Editora e WHERE e.idEditora = :idEditora")
    Optional<Editora> findEditoraById(int idEditora);

    // Consulta personalizada para buscar editoras por nome
    @Query("SELECT e FROM Editora e WHERE e.nomeEditora LIKE %:nomeEditora%")
    List<Editora> findEditorasByNome(String nomeEditora);
}