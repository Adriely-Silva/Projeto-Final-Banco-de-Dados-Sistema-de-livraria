package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Pagamento;
import com.example.sistema_livraria.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Método para inserir um pagamento usando query nativa
    public void insertPagamento(Double boleto, Double credito, Double debito, Double pix, int idPedido) {
        pagamentoRepository.insertPagamento(boleto, credito, debito, pix, idPedido);
    }

    // Método para deletar um pagamento por ID usando query nativa
    public void deletePagamentoById(int id) {
        pagamentoRepository.deletePagamentoById(id);
    }


    // Método para salvar um pagamento
    public Pagamento savePagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    // Método para buscar todos os pagamentos
    public List<Pagamento> findAllPagamentos() {
        return pagamentoRepository.findAllPagamentos();
    }

    // Método para buscar um pagamento por ID
    public Optional<Pagamento> findPagamentoById(int id) {
        return pagamentoRepository.findPagamentoById(id);
    }

    // Método para buscar pagamentos por ID do Pedido
    public List<Pagamento> findPagamentosByPedidoId(int idPedido) {
        return pagamentoRepository.findPagamentosByPedidoId(idPedido);
    }
}