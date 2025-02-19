package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.PagamentoService;
import com.example.sistema_livraria.models.Pagamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;


    // Endpoint para inserir um pagamento usando query nativa
    @PostMapping("/insert")
    public void insertPagamento(
            @RequestParam(required = false) Double boleto, // Opcional
            @RequestParam(required = false) Double credito, // Opcional
            @RequestParam(required = false) Double debito, // Opcional
            @RequestParam(required = false) Double pix, // Opcional
            @RequestParam int idPedido
    ) {
        pagamentoService.insertPagamento(boleto, credito, debito, pix, idPedido);
    }

    // Endpoint para deletar um pagamento por ID usando query nativa
    @Modifying
    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deletePagamentoById(@PathVariable int id) {
        pagamentoService.deletePagamentoById(id);
    }

    // Endpoint para salvar um pagamento
    @PostMapping
    public Pagamento savePagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.savePagamento(pagamento);
    }

    // Endpoint para buscar todos os pagamentos
    @GetMapping
    public List<Pagamento> findAllPagamentos() {
        return pagamentoService.findAllPagamentos();
    }

    // Endpoint para buscar um pagamento por ID
    @GetMapping("/{id}")
    public Optional<Pagamento> findPagamentoById(@PathVariable int id) {
        return pagamentoService.findPagamentoById(id);
    }

    // Endpoint para buscar pagamentos por ID do Pedido
    @GetMapping("/pedido/{idPedido}")
    public List<Pagamento> findPagamentosByPedidoId(@PathVariable int idPedido) {
        return pagamentoService.findPagamentosByPedidoId(idPedido);
    }
}