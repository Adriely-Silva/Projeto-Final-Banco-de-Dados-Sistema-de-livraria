package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.AluguelLivroService;
import com.example.sistema_livraria.models.AluguelLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluguel-livro")
public class AluguelLivroController {

    @Autowired
    private AluguelLivroService aluguelLivroService;

    // Endpoint para salvar uma associação Aluguel-Livro
    @PostMapping
    public AluguelLivro saveAluguelLivro(@RequestBody AluguelLivro aluguelLivro) {
        return aluguelLivroService.saveAluguelLivro(aluguelLivro);
    }

    // Endpoint para buscar todas as associações Aluguel-Livro
    @GetMapping
    public List<AluguelLivro> findAllAluguelLivros() {
        return aluguelLivroService.findAllAluguelLivros();
    }

    // Endpoint para buscar uma associação Aluguel-Livro por ID do Aluguel
    @GetMapping("/{idAluguel}")
    public Optional<AluguelLivro> findAluguelLivroById(@PathVariable int idAluguel) {
        return aluguelLivroService.findAluguelLivroById(idAluguel);
    }

    // Endpoint para buscar associações Aluguel-Livro por data de devolução
    @GetMapping("/devolucao/{dataDevolucao}")
    public List<AluguelLivro> findAluguelLivrosByDataDevolucao(@PathVariable LocalDateTime dataDevolucao) {
        return aluguelLivroService.findAluguelLivrosByDataDevolucao(dataDevolucao);
    }
}