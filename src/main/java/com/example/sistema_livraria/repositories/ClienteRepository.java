package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    // Query nativa para INSERT
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Cliente (Nome_Cliente, Fidelidade, CPF_Cliente) VALUES (:nomeCliente, :fidelidade, :cpfCliente)",
            nativeQuery = true
    )
    void insertCliente(String nomeCliente, String fidelidade, long cpfCliente);



    // Query nativa para DELETE
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Cliente WHERE ID_Cliente = :idCliente",
            nativeQuery = true
    )
    void deleteClienteById(int idCliente);



    // Consulta personalizada para buscar todos os clientes
    @Query("SELECT c FROM Cliente c")
    List<Cliente> findAllClientes();

    // Consulta personalizada para buscar um cliente por ID
    @Query("SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    Optional<Cliente> findClienteById(int idCliente);

    // Consulta personalizada para buscar clientes por nome
    @Query("SELECT c FROM Cliente c WHERE c.nomeCliente LIKE %:nomeCliente%")
    List<Cliente> findClientesByNome(String nomeCliente);

    // Consulta personalizada para buscar clientes por CPF
    @Query("SELECT c FROM Cliente c WHERE c.cpfCliente = :cpfCliente")
    Optional<Cliente> findClienteByCpf(long cpfCliente);
}