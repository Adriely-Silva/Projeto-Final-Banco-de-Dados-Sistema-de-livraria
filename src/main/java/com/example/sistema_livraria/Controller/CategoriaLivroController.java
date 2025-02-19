package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.CategoriaLivroService;
import com.example.sistema_livraria.models.CategoriaLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria-livro")
public class CategoriaLivroController {

    @Autowired
    private CategoriaLivroService categoriaLivroService;

    // Endpoint para salvar uma associação Categoria-Livro
    @PostMapping
    public CategoriaLivro saveCategoriaLivro(@RequestBody CategoriaLivro categoriaLivro) {
        return categoriaLivroService.saveCategoriaLivro(categoriaLivro);
    }

    // Endpoint para buscar todas as associações Categoria-Livro
    @GetMapping
    public List<CategoriaLivro> findAllCategoriaLivro() {
        return categoriaLivroService.findAllCategoriaLivro();
    }

    // Endpoint para buscar associações por ID da Categoria
    @GetMapping("/categoria/{idCategoria}")
    public List<CategoriaLivro> findByCategoriaId(@PathVariable int idCategoria) {
        return categoriaLivroService.findByCategoriaId(idCategoria);
    }

    // Endpoint para buscar associações por ID do Livro
    @GetMapping("/livro/{idLivro}")
    public List<CategoriaLivro> findByLivroId(@PathVariable int idLivro) {
        return categoriaLivroService.findByLivroId(idLivro);
    }
}