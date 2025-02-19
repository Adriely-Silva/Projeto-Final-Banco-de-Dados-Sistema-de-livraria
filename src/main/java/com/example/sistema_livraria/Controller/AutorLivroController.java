package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.AutorLivroService;
import com.example.sistema_livraria.models.AutorLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor-livro")
public class AutorLivroController {

    @Autowired
    private AutorLivroService autorLivroService;

    // Endpoint para salvar uma associação Autor-Livro
    @PostMapping
    public AutorLivro saveAutorLivro(@RequestBody AutorLivro autorLivro) {
        return autorLivroService.saveAutorLivro(autorLivro);
    }

    // Endpoint para buscar todas as associações Autor-Livro
    @GetMapping
    public List<AutorLivro> findAllAutorLivro() {
        return autorLivroService.findAllAutorLivro();
    }

    // Endpoint para buscar associações por ID do Autor
    @GetMapping("/autor/{idAutor}")
    public List<AutorLivro> findByAutorId(@PathVariable int idAutor) {
        return autorLivroService.findByAutorId(idAutor);
    }

    // Endpoint para buscar associações por ID do Livro
    @GetMapping("/livro/{idLivro}")
    public List<AutorLivro> findByLivroId(@PathVariable int idLivro) {
        return autorLivroService.findByLivroId(idLivro);
    }
}