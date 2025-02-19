package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.PrateleiraService;
import com.example.sistema_livraria.models.Prateleira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prateleiras")
public class PrateleiraController {

    @Autowired
    private PrateleiraService prateleiraService;

    // Endpoint para salvar uma prateleira
    @PostMapping
    public Prateleira savePrateleira(@RequestBody Prateleira prateleira) {
        return prateleiraService.savePrateleira(prateleira);
    }

    // Endpoint para buscar todas as prateleiras
    @GetMapping
    public List<Prateleira> findAllPrateleiras() {
        return prateleiraService.findAllPrateleiras();
    }

    // Endpoint para buscar uma prateleira por ID
    @GetMapping("/{idPrat}")
    public Optional<Prateleira> findPrateleiraById(@PathVariable int idPrat) {
        return prateleiraService.findPrateleiraById(idPrat);
    }

    // Endpoint para buscar prateleiras por número do corredor
    @GetMapping("/corredor/{numCorredor}")
    public List<Prateleira> findPrateleirasByNumCorredor(@PathVariable int numCorredor) {
        return prateleiraService.findPrateleirasByNumCorredor(numCorredor);
    }
}