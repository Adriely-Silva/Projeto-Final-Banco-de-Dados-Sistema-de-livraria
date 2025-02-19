package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


    // Query nativa para INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Pedido (ID_Func, Data_Pedido, ID_Livro, ID_Aluguel, ID_Cliente) VALUES (:idFunc, :dataPedido, :idLivro, :idAluguel, :idCliente)",
            nativeQuery = true
    )
    void insertPedido(int idFunc, LocalDateTime dataPedido, Integer idLivro, Integer idAluguel, int idCliente);

    // Query nativa para DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Pedido WHERE ID_Pedido = :idPedido",
            nativeQuery = true
    )
    void deletePedidoById(int idPedido);

    // Consulta personalizada para buscar todos os pedidos
    @Query("SELECT p FROM Pedido p")
    List<Pedido> findAllPedidos();

    // Consulta personalizada para buscar um pedido por ID
    @Query("SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    Optional<Pedido> findPedidoById(int idPedido);

    // Consulta personalizada para buscar pedidos por data
    @Query("SELECT p FROM Pedido p WHERE p.dataPedido = :dataPedido")
    List<Pedido> findPedidosByData(LocalDateTime dataPedido);

    // Consulta personalizada para buscar pedidos por ID do Funcionário
    @Query("SELECT p FROM Pedido p WHERE p.funcionario.idFunc = :idFunc")
    List<Pedido> findPedidosByFuncionarioId(int idFunc);

    // Consulta personalizada para buscar pedidos por ID do Cliente
    @Query("SELECT p FROM Pedido p WHERE p.cliente.idCliente = :idCliente")
    List<Pedido> findPedidosByClienteId(int idCliente);
}
