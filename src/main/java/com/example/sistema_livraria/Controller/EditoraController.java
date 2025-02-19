package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.EditoraService;
import com.example.sistema_livraria.models.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    // Endpoint para salvar uma editora
    @PostMapping
    public Editora saveEditora(@RequestBody Editora editora) {
        return editoraService.saveEditora(editora);
    }

    // Endpoint para buscar todas as editoras
    @GetMapping
    public List<Editora> findAllEditoras() {
        return editoraService.findAllEditoras();
    }

    // Endpoint para buscar uma editora por ID
    @GetMapping("/{idEditora}")
    public Optional<Editora> findEditoraById(@PathVariable int idEditora) {
        return editoraService.findEditoraById(idEditora);
    }

    // Endpoint para buscar editoras por nome
    @GetMapping("/nome/{nomeEditora}")
    public List<Editora> findEditorasByNome(@PathVariable String nomeEditora) {
        return editoraService.findEditorasByNome(nomeEditora);
    }
}