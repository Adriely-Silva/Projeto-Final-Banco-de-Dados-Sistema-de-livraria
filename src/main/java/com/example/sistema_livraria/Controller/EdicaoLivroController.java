package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.EdicaoLivroService;
import com.example.sistema_livraria.models.EdicaoLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edicao-livro")
public class EdicaoLivroController {

    @Autowired
    private EdicaoLivroService edicaoLivroService;

    // Endpoint para salvar uma associação Edicao-Livro
    @PostMapping
    public EdicaoLivro saveEdicaoLivro(@RequestBody EdicaoLivro edicaoLivro) {
        return edicaoLivroService.saveEdicaoLivro(edicaoLivro);
    }

    // Endpoint para buscar todas as associações Edicao-Livro
    @GetMapping
    public List<EdicaoLivro> findAllEdicaoLivro() {
        return edicaoLivroService.findAllEdicaoLivro();
    }

    // Endpoint para buscar associações por ID da Edicao
    @GetMapping("/edicao/{idEdicao}")
    public List<EdicaoLivro> findByEdicaoId(@PathVariable int idEdicao) {
        return edicaoLivroService.findByEdicaoId(idEdicao);
    }

    // Endpoint para buscar associações por ID do Livro
    @GetMapping("/livro/{idLivro}")
    public List<EdicaoLivro> findByLivroId(@PathVariable int idLivro) {
        return edicaoLivroService.findByLivroId(idLivro);
    }
}