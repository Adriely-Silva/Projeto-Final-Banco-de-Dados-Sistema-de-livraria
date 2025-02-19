package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.EdicaoService;
import com.example.sistema_livraria.models.Edicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/edicoes")
public class EdicaoController {

    @Autowired
    private EdicaoService edicaoService;

    // Endpoint para salvar uma edição
    @PostMapping
    public Edicao saveEdicao(@RequestBody Edicao edicao) {
        return edicaoService.saveEdicao(edicao);
    }

    // Endpoint para buscar todas as edições
    @GetMapping
    public List<Edicao> findAllEdicoes() {
        return edicaoService.findAllEdicoes();
    }

    // Endpoint para buscar uma edição por ID
    @GetMapping("/{idEdicao}")
    public Optional<Edicao> findEdicaoById(@PathVariable int idEdicao) {
        return edicaoService.findEdicaoById(idEdicao);
    }

    // Endpoint para buscar edições por número de edição
    @GetMapping("/numero/{numEdicao}")
    public List<Edicao> findEdicoesByNumEdicao(@PathVariable int numEdicao) {
        return edicaoService.findEdicoesByNumEdicao(numEdicao);
    }
}