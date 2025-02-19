package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.LivrosAlugadosService;
import com.example.sistema_livraria.models.LivrosAlugados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros-alugados")
public class LivrosAlugadosController {

    @Autowired
    private LivrosAlugadosService livrosAlugadosService;

    // Endpoint para salvar uma associação Livros-Alugados
    @PostMapping
    public LivrosAlugados saveLivrosAlugados(@RequestBody LivrosAlugados livrosAlugados) {
        return livrosAlugadosService.saveLivrosAlugados(livrosAlugados);
    }

    // Endpoint para buscar todas as associações Livros-Alugados
    @GetMapping
    public List<LivrosAlugados> findAllLivrosAlugados() {
        return livrosAlugadosService.findAllLivrosAlugados();
    }

    // Endpoint para buscar associações por ID do Aluguel_Livro
    @GetMapping("/aluguel/{idAluguel}")
    public List<LivrosAlugados> findByAluguelLivroId(@PathVariable int idAluguel) {
        return livrosAlugadosService.findByAluguelLivroId(idAluguel);
    }

    // Endpoint para buscar associações por ID do Livro
    @GetMapping("/livro/{idLivro}")
    public List<LivrosAlugados> findByLivroId(@PathVariable int idLivro) {
        return livrosAlugadosService.findByLivroId(idLivro);
    }
}