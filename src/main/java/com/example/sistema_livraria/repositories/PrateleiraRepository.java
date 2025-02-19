package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Prateleira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrateleiraRepository extends JpaRepository<Prateleira, Integer> {

    // Consulta personalizada para buscar todas as prateleiras
    @Query("SELECT p FROM Prateleira p")
    List<Prateleira> findAllPrateleiras();

    // Consulta personalizada para buscar uma prateleira por ID
    @Query("SELECT p FROM Prateleira p WHERE p.idPrat = :idPrat")
    Optional<Prateleira> findPrateleiraById(int idPrat);

    // Consulta personalizada para buscar prateleiras por número do corredor
    @Query("SELECT p FROM Prateleira p WHERE p.numCorredor = :numCorredor")
    List<Prateleira> findPrateleirasByNumCorredor(int numCorredor);
}