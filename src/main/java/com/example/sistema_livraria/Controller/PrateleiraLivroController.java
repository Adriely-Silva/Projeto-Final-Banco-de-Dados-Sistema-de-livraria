package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.PrateleiraLivroService;
import com.example.sistema_livraria.models.PrateleiraLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prateleira-livro")
public class PrateleiraLivroController {

    @Autowired
    private PrateleiraLivroService prateleiraLivroService;

    // Endpoint para salvar uma associação Prateleira-Livro
    @PostMapping
    public PrateleiraLivro savePrateleiraLivro(@RequestBody PrateleiraLivro prateleiraLivro) {
        return prateleiraLivroService.savePrateleiraLivro(prateleiraLivro);
    }

    // Endpoint para buscar todas as associações Prateleira-Livro
    @GetMapping
    public List<PrateleiraLivro> findAllPrateleiraLivro() {
        return prateleiraLivroService.findAllPrateleiraLivro();
    }

    // Endpoint para buscar associações por ID da Prateleira
    @GetMapping("/prateleira/{idPrat}")
    public List<PrateleiraLivro> findByPrateleiraId(@PathVariable int idPrat) {
        return prateleiraLivroService.findByPrateleiraId(idPrat);
    }

    // Endpoint para buscar associações por ID do Livro
    @GetMapping("/livro/{idLivro}")
    public List<PrateleiraLivro> findByLivroId(@PathVariable int idLivro) {
        return prateleiraLivroService.findByLivroId(idLivro);
    }
}