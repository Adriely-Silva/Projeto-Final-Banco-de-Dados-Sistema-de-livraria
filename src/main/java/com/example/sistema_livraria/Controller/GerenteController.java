package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.GerenteService;
import com.example.sistema_livraria.models.Gerente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    // Endpoint para inserir um gerente usando query nativa
    @PostMapping("/insert")
    public void insertGerente(
            @RequestParam int idFunc,
            @RequestParam String tipoFunc
    ) {
        gerenteService.insertGerente(idFunc, tipoFunc);
    }

    // Endpoint para deletar um gerente por ID usando query nativa
    @Modifying
    @Transactional
    @DeleteMapping("/delete/{idFunc}")
    public void deleteGerenteById(@PathVariable int idFunc) {
        gerenteService.deleteGerenteById(idFunc);
    }

    // Endpoint para salvar um gerente
    @PostMapping
    public Gerente saveGerente(@RequestBody Gerente gerente) {
        return gerenteService.saveGerente(gerente);
    }

    // Endpoint para buscar todos os gerentes
    @GetMapping
    public List<Gerente> findAllGerentes() {
        return gerenteService.findAllGerentes();
    }

    // Endpoint para buscar um gerente por ID
    @GetMapping("/{idFunc}")
    public Optional<Gerente> findGerenteById(@PathVariable int idFunc) {
        return gerenteService.findGerenteById(idFunc);
    }

    // Endpoint para buscar gerentes por tipo
    @GetMapping("/tipo/{tipoFunc}")
    public List<Gerente> findGerentesByTipo(@PathVariable String tipoFunc) {
        return gerenteService.findGerentesByTipo(tipoFunc);
    }
}