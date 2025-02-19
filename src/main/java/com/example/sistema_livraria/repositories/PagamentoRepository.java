package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Pagamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Pagamento (Boleto, Crédito, Débito, Pix, id_Pedido) VALUES (:boleto, :credito, :debito, :pix, :idPedido)",
            nativeQuery = true
    )
    void insertPagamento(Double boleto, Double credito, Double debito, Double pix, int idPedido);

    // Query nativa para DELETE
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Pagamento WHERE ID = :id",
            nativeQuery = true
    )
    void deletePagamentoById(int id);

    // Consulta personalizada para buscar todos os pagamentos
    @Query("SELECT p FROM Pagamento p")
    List<Pagamento> findAllPagamentos();

    // Consulta personalizada para buscar um pagamento por ID
    @Query("SELECT p FROM Pagamento p WHERE p.id = :id")
    Optional<Pagamento> findPagamentoById(int id);

    // Consulta personalizada para buscar pagamentos por ID do Pedido
    @Query("SELECT p FROM Pagamento p WHERE p.pedido.idPedido = :idPedido")
    List<Pagamento> findPagamentosByPedidoId(int idPedido);
}
