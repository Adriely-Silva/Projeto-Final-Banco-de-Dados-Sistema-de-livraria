package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EdicaoRepository extends JpaRepository<Edicao, Integer> {

    // Consulta personalizada para buscar todas as edições
    @Query("SELECT e FROM Edicao e")
    List<Edicao> findAllEdicoes();

    // Consulta personalizada para buscar uma edição por ID
    @Query("SELECT e FROM Edicao e WHERE e.idEdicao = :idEdicao")
    Optional<Edicao> findEdicaoById(int idEdicao);

    // Consulta personalizada para buscar edições por número de edição
    @Query("SELECT e FROM Edicao e WHERE e.numEdicao = :numEdicao")
    List<Edicao> findEdicoesByNumEdicao(int numEdicao);
}