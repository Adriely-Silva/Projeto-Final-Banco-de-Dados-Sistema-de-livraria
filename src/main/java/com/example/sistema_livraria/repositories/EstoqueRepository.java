package com.example.sistema_livraria.repositories;


import com.example.sistema_livraria.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

    // Consulta personalizada para buscar todas as entradas de estoque
    @Query("SELECT e FROM Estoque e")
    List<Estoque> findAllEstoques();

    // Consulta personalizada para buscar uma entrada de estoque por ID do Livro
    @Query("SELECT e FROM Estoque e WHERE e.idLivro = :idLivro")
    Optional<Estoque> findEstoqueByIdLivro(int idLivro);

    // Consulta personalizada para buscar entradas de estoque com quantidade maior que um valor
    @Query("SELECT e FROM Estoque e WHERE e.quantidade > :quantidade")
    List<Estoque> findEstoquesByQuantidadeGreaterThan(int quantidade);

    // Triggers
    @Modifying
    @Query(value = "INSERT INTO Estoque (idLivro, Quantidade) VALUES (:idLivro, 0)", nativeQuery = true)
    void insertEstoqueForNewLivro(@Param("idLivro") int idLivro);

    @Modifying
    @Query(value = "DELETE FROM Estoque WHERE idLivro = :idLivro", nativeQuery = true)
    void deleteEstoqueByLivroId(@Param("idLivro") int idLivro);
}