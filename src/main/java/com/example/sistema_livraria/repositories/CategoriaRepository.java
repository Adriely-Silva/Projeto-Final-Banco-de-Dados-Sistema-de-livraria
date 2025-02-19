package com.example.sistema_livraria.repositories;


import com.example.sistema_livraria.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    // Consulta personalizada para buscar todas as categorias
    @Query("SELECT c FROM Categoria c")
    List<Categoria> findAllCategorias();

    // Consulta personalizada para buscar uma categoria por ID
    @Query("SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria")
    Optional<Categoria> findCategoriaById(int idCategoria);

    // Consulta personalizada para buscar categorias por nome
    @Query("SELECT c FROM Categoria c WHERE c.nomeCategoria LIKE %:nomeCategoria%")
    List<Categoria> findCategoriasByNome(String nomeCategoria);
}