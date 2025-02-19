package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.EstoqueService;
import com.example.sistema_livraria.models.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    // Endpoint para salvar uma entrada de estoque
    @PostMapping
    public Estoque saveEstoque(@RequestBody Estoque estoque) {
        return estoqueService.saveEstoque(estoque);
    }

    // Endpoint para buscar todas as entradas de estoque
    @GetMapping
    public List<Estoque> findAllEstoques() {
        return estoqueService.findAllEstoques();
    }

    // Endpoint para buscar uma entrada de estoque por ID do Livro
    @GetMapping("/livro/{idLivro}")
    public Optional<Estoque> findEstoqueByIdLivro(@PathVariable int idLivro) {
        return estoqueService.findEstoqueByIdLivro(idLivro);
    }

    // Endpoint para buscar entradas de estoque com quantidade maior que um valor
    @GetMapping("/quantidade/{quantidade}")
    public List<Estoque> findEstoquesByQuantidadeGreaterThan(@PathVariable int quantidade) {
        return estoqueService.findEstoquesByQuantidadeGreaterThan(quantidade);
    }
}