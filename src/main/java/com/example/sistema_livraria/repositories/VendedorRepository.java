package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Vendedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    // Query nativa para INSERT
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Vendedor (ID_Func, Meta_Vendas) VALUES (:idFunc, :metaVendas)",
            nativeQuery = true
    )
    void insertVendedor(int idFunc, double metaVendas);

    // Query nativa para DELETE
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Vendedor WHERE ID_Func = :idFunc",
            nativeQuery = true
    )
    void deleteVendedorById(int idFunc);

    // Consulta personalizada para buscar todos os vendedores
    @Query("SELECT v FROM Vendedor v")
    List<Vendedor> findAllVendedores();

    // Consulta personalizada para buscar um vendedor por ID
    @Query("SELECT v FROM Vendedor v WHERE v.idFunc = :idFunc")
    Optional<Vendedor> findVendedorById(int idFunc);

    // Consulta personalizada para buscar vendedores com meta de vendas maior que um valor
    @Query("SELECT v FROM Vendedor v WHERE v.metaVendas > :metaVendas")
    List<Vendedor> findVendedoresByMetaVendasGreaterThan(double metaVendas);
}