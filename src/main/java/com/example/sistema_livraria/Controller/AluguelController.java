package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.AluguelService;
import com.example.sistema_livraria.models.Aluguel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    // Endpoint para salvar um aluguel
    @PostMapping
    public Aluguel saveAluguel(@RequestBody Aluguel aluguel) {
        return aluguelService.saveAluguel(aluguel);
    }

    // Endpoint para buscar todos os aluguéis
    @GetMapping
    public List<Aluguel> findAllAlugueis() {
        return aluguelService.findAllAlugueis();
    }

    // Endpoint para buscar um aluguel por ID
    @GetMapping("/{idAluguel}")
    public Optional<Aluguel> findAluguelById(@PathVariable int idAluguel) {
        return aluguelService.findAluguelById(idAluguel);
    }

    // Endpoint para buscar aluguéis por data
    @GetMapping("/data/{data}")
    public List<Aluguel> findAlugueisByData(@PathVariable LocalDateTime data) {
        return aluguelService.findAlugueisByData(data);
    }

    // Endpoint para buscar aluguéis com valor maior que um valor
    @GetMapping("/valor/{valor}")
    public List<Aluguel> findAlugueisByValorGreaterThan(@PathVariable double valor) {
        return aluguelService.findAlugueisByValorGreaterThan(valor);
    }
}