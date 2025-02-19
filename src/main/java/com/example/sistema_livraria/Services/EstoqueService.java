package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Estoque;
import com.example.sistema_livraria.repositories.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Método para salvar uma entrada de estoque
    public Estoque saveEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    // Criar estoque ao adicionar um livro
    @Transactional
    public void createEstoqueForLivro(int idLivro) {
        estoqueRepository.insertEstoqueForNewLivro(idLivro);
    }

    // Remover estoque ao excluir um livro
    @Transactional
    public void removeEstoqueForLivro(int idLivro) {
        estoqueRepository.deleteEstoqueByLivroId(idLivro);
    }

    // Método para buscar todas as entradas de estoque
    public List<Estoque> findAllEstoques() {
        return estoqueRepository.findAllEstoques();
    }

    // Método para buscar uma entrada de estoque por ID do Livro
    public Optional<Estoque> findEstoqueByIdLivro(int idLivro) {
        return estoqueRepository.findEstoqueByIdLivro(idLivro);
    }

    // Método para buscar entradas de estoque com quantidade maior que um valor
    public List<Estoque> findEstoquesByQuantidadeGreaterThan(int quantidade) {
        return estoqueRepository.findEstoquesByQuantidadeGreaterThan(quantidade);
    }
}