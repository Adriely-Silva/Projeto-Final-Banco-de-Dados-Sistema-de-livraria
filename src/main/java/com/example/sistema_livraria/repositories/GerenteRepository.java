package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Gerente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {

    // Query nativa para INSERT
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Gerente (ID_Func, Tipo_Func) VALUES (:idFunc, :tipoFunc)",
            nativeQuery = true
    )
    void insertGerente(int idFunc, String tipoFunc);

    // Query nativa para DELETE
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Gerente WHERE ID_Func = :idFunc",
            nativeQuery = true
    )
    void deleteGerenteById(int idFunc);


    // Consulta personalizada para buscar todos os gerentes
    @Query("SELECT g FROM Gerente g")
    List<Gerente> findAllGerentes();

    // Consulta personalizada para buscar um gerente por ID
    @Query("SELECT g FROM Gerente g WHERE g.idFunc = :idFunc")
    Optional<Gerente> findGerenteById(int idFunc);

    // Consulta personalizada para buscar gerentes por tipo
    @Query("SELECT g FROM Gerente g WHERE g.tipoFunc = :tipoFunc")
    List<Gerente> findGerentesByTipo(String tipoFunc);
}