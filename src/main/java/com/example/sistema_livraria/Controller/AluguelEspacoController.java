package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.AluguelEspacoService;
import com.example.sistema_livraria.models.AluguelEspaco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluguel-espaco")
public class AluguelEspacoController {

    @Autowired
    private AluguelEspacoService aluguelEspacoService;

    // Endpoint para salvar uma associação Aluguel-Espaço
    @PostMapping
    public AluguelEspaco saveAluguelEspaco(@RequestBody AluguelEspaco aluguelEspaco) {
        return aluguelEspacoService.saveAluguelEspaco(aluguelEspaco);
    }

    // Endpoint para buscar todas as associações Aluguel-Espaço
    @GetMapping
    public List<AluguelEspaco> findAllAluguelEspacos() {
        return aluguelEspacoService.findAllAluguelEspacos();
    }

    // Endpoint para buscar uma associação Aluguel-Espaço por ID do Aluguel
    @GetMapping("/{idAluguel}")
    public Optional<AluguelEspaco> findAluguelEspacoById(@PathVariable int idAluguel) {
        return aluguelEspacoService.findAluguelEspacoById(idAluguel);
    }

    // Endpoint para buscar associações Aluguel-Espaço por tempo de aluguel
    @GetMapping("/tempo/{tempoAluguel}")
    public List<AluguelEspaco> findAluguelEspacosByTempoAluguel(@PathVariable String tempoAluguel) {
        return aluguelEspacoService.findAluguelEspacosByTempoAluguel(tempoAluguel);
    }
}