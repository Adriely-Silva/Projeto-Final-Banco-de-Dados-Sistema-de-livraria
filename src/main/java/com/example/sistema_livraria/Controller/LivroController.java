package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.LivroService;
import com.example.sistema_livraria.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Endpoint para inserir um livro usando query nativa
    @PostMapping("/insert")
    public void insertLivro(
            @RequestParam String titulo,
            @RequestParam double preco,
            @RequestParam long isbn,
            @RequestParam int idEditora
    ) {
        livroService.insertLivro(titulo, preco, isbn, idEditora);
    }

    // Endpoint para inserir vários livros de uma vez
    @PostMapping("/insertMany")
    public void insertManyLivros(@RequestBody List<Livro> livros) {
        livroService.insertManyLivros(livros);
    }

    // Endpoint para deletar um livro por ID usando query nativa
    @DeleteMapping("/delete/{idLivro}")
    public void deleteLivroById(@PathVariable int idLivro) {
        livroService.deleteLivroById(idLivro);
    }

    // Endpoint para atualizar um livro por ID usando query nativa
    @PutMapping("/update/{idLivro}")
    public void updateLivroById(
            @PathVariable int idLivro,
            @RequestParam String titulo,
            @RequestParam double preco,
            @RequestParam long isbn,
            @RequestParam int idEditora
    ) {
        livroService.updateLivroById(idLivro, titulo, preco, isbn, idEditora);
    }

    // Endpoint para salvar um livro
    @PostMapping
    public Livro saveLivro(@RequestBody Livro livro) {
        return livroService.saveLivro(livro);
    }

    // Endpoint para buscar todos os livros
    @GetMapping
    public List<Livro> findAllLivros() {
        return livroService.findAllLivros();
    }

    // Endpoint para buscar um livro por ID
    @GetMapping("/{idLivro}")
    public Optional<Livro> findLivroById(@PathVariable int idLivro) {
        return livroService.findLivroById(idLivro);
    }

    // Endpoint para buscar livros por título
    @GetMapping("/titulo/{titulo}")
    public List<Livro> findLivrosByTitulo(@PathVariable String titulo) {
        return livroService.findLivrosByTitulo(titulo);
    }

    // Endpoint para buscar livros por editora
    @GetMapping("/editora/{idEditora}")
    public List<Livro> findLivrosByEditora(@PathVariable int idEditora) {
        return livroService.findLivrosByEditora(idEditora);
    }


    // Endpoint para contar livros por editora com preço médio acima de 40.00
    @GetMapping("/estatisticas/por-editora")
    public List<Object[]> contarLivrosPorEditora() {
        return livroService.contarLivrosPorEditora();
    }
    @GetMapping("/ordenados")
    public List<Livro> getLivrosOrdenados(
            @RequestParam String orderBy,
            @RequestParam String direction) {
        return livroService.getAllLivrosSorted(orderBy, direction);
    }

    @GetMapping("/preco-maior-que-todos/{editoraId}")
    public List<Livro> getLivrosPrecoMaiorQueTodos(@PathVariable int editoraId) {
        return livroService.getLivrosPrecoMaiorQueTodosDaEditora(editoraId);
    }

    @GetMapping("/{idLivro}/estoque")
    public ResponseEntity<Integer> getQuantidadeEstoque(@PathVariable int idLivro) {
        Integer quantidade = livroService.getQuantidadeEstoque(idLivro);
        if (quantidade == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quantidade);
    }
}