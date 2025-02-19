package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Prateleira;
import com.example.sistema_livraria.repositories.PrateleiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrateleiraService {

    @Autowired
    private PrateleiraRepository prateleiraRepository;

    // Método para salvar uma prateleira
    public Prateleira savePrateleira(Prateleira prateleira) {
        return prateleiraRepository.save(prateleira);
    }

    // Método para buscar todas as prateleiras
    public List<Prateleira> findAllPrateleiras() {
        return prateleiraRepository.findAllPrateleiras();
    }

    // Método para buscar uma prateleira por ID
    public Optional<Prateleira> findPrateleiraById(int idPrat) {
        return prateleiraRepository.findPrateleiraById(idPrat);
    }

    // Método para buscar prateleiras por número do corredor
    public List<Prateleira> findPrateleirasByNumCorredor(int numCorredor) {
        return prateleiraRepository.findPrateleirasByNumCorredor(numCorredor);
    }
}