package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.repositories.PedidoRepository;
import com.example.sistema_livraria.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    // Método para inserir um pedido usando query nativa
    public void insertPedido(int idFunc, LocalDateTime dataPedido, Integer idLivro, Integer idAluguel, int idCliente) {
        pedidoRepository.insertPedido(idFunc, dataPedido, idLivro, idAluguel, idCliente);
    }

    // Método para deletar um pedido por ID usando query nativa
    public void deletePedidoById(int idPedido) {
        pedidoRepository.deletePedidoById(idPedido);
    }

    // Método para salvar um pedido
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Método para buscar todos os pedidos
    public List<Pedido> findAllPedidos() {
        return pedidoRepository.findAllPedidos();
    }

    // Método para buscar um pedido por ID
    public Optional<Pedido> findPedidoById(int idPedido) {
        return pedidoRepository.findPedidoById(idPedido);
    }

    // Método para buscar pedidos por data
    public List<Pedido> findPedidosByData(LocalDateTime dataPedido) {
        return pedidoRepository.findPedidosByData(dataPedido);
    }

    // Método para buscar pedidos por ID do Funcionário
    public List<Pedido> findPedidosByFuncionarioId(int idFunc) {
        return pedidoRepository.findPedidosByFuncionarioId(idFunc);
    }

    // Método para buscar pedidos por ID do Cliente
    public List<Pedido> findPedidosByClienteId(int idCliente) {
        return pedidoRepository.findPedidosByClienteId(idCliente);
    }
}