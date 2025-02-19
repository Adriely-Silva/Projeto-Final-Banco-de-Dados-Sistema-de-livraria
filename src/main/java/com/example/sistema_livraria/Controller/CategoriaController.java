package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.CategoriaService;
import com.example.sistema_livraria.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Endpoint para salvar uma categoria
    @PostMapping
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    // Endpoint para buscar todas as categorias
    @GetMapping
    public List<Categoria> findAllCategorias() {
        return categoriaService.findAllCategorias();
    }

    // Endpoint para buscar uma categoria por ID
    @GetMapping("/{idCategoria}")
    public Optional<Categoria> findCategoriaById(@PathVariable int idCategoria) {
        return categoriaService.findCategoriaById(idCategoria);
    }

    // Endpoint para buscar categorias por nome
    @GetMapping("/nome/{nomeCategoria}")
    public List<Categoria> findCategoriasByNome(@PathVariable String nomeCategoria) {
        return categoriaService.findCategoriasByNome(nomeCategoria);
    }
}
