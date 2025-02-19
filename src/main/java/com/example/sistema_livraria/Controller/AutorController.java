package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.AutorService;
import com.example.sistema_livraria.models.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Endpoint para salvar um autor
    @PostMapping
    public Autor saveAutor(@RequestBody Autor autor) {
        return autorService.saveAutor(autor);
    }

    // Endpoint para buscar todos os autores
    @GetMapping
    public List<Autor> findAllAutores() {
        return autorService.findAllAutores();
    }

    // Endpoint para buscar um autor por ID
    @GetMapping("/{idAutor}")
    public Optional<Autor> findAutorById(@PathVariable int idAutor) {
        return autorService.findAutorById(idAutor);
    }

    // Endpoint para buscar autores por nome
    @GetMapping("/nome/{nomeAutor}")
    public List<Autor> findAutoresByNome(@PathVariable String nomeAutor) {
        return autorService.findAutoresByNome(nomeAutor);
    }
}