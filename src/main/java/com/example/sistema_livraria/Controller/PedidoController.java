package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.PedidoService;
import com.example.sistema_livraria.models.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoint para inserir um pedido usando query nativa
    @PostMapping("/insert")
    public void insertPedido(
            @RequestParam int idFunc,
            @RequestParam String dataPedido, // Recebe como String e converte para LocalDateTime
            @RequestParam(required = false) Integer idLivro, // Opcional
            @RequestParam(required = false) Integer idAluguel, // Opcional
            @RequestParam int idCliente
    ) {
        // Converte a string de data para LocalDateTime
        LocalDateTime data = LocalDateTime.parse(dataPedido);
        pedidoService.insertPedido(idFunc, data, idLivro, idAluguel, idCliente);
    }

    // Endpoint para deletar um pedido por ID usando query nativa
    @Modifying
    @Transactional
    @DeleteMapping("/delete/{idPedido}")
    public void deletePedidoById(@PathVariable int idPedido) {
        pedidoService.deletePedidoById(idPedido);
    }

    // Endpoint para salvar um pedido
    @PostMapping
    public Pedido savePedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    // Endpoint para buscar todos os pedidos
    @GetMapping
    public List<Pedido> findAllPedidos() {
        return pedidoService.findAllPedidos();
    }

    // Endpoint para buscar um pedido por ID
    @GetMapping("/{idPedido}")
    public Optional<Pedido> findPedidoById(@PathVariable int idPedido) {
        return pedidoService.findPedidoById(idPedido);
    }

    // Endpoint para buscar pedidos por data
    @GetMapping("/data/{dataPedido}")
    public List<Pedido> findPedidosByData(@PathVariable LocalDateTime dataPedido) {
        return pedidoService.findPedidosByData(dataPedido);
    }

    // Endpoint para buscar pedidos por ID do Funcionário
    @GetMapping("/funcionario/{idFunc}")
    public List<Pedido> findPedidosByFuncionarioId(@PathVariable int idFunc) {
        return pedidoService.findPedidosByFuncionarioId(idFunc);
    }

    // Endpoint para buscar pedidos por ID do Cliente
    @GetMapping("/cliente/{idCliente}")
    public List<Pedido> findPedidosByClienteId(@PathVariable int idCliente) {
        return pedidoService.findPedidosByClienteId(idCliente);
    }
}