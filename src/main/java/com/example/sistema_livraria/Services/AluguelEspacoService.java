package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.AluguelEspaco;
import com.example.sistema_livraria.repositories.AluguelEspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelEspacoService {

    @Autowired
    private AluguelEspacoRepository aluguelEspacoRepository;

    // Método para salvar uma associação Aluguel-Espaço
    public AluguelEspaco saveAluguelEspaco(AluguelEspaco aluguelEspaco) {
        return aluguelEspacoRepository.save(aluguelEspaco);
    }

    // Método para buscar todas as associações Aluguel-Espaço
    public List<AluguelEspaco> findAllAluguelEspacos() {
        return aluguelEspacoRepository.findAllAluguelEspacos();
    }

    // Método para buscar uma associação Aluguel-Espaço por ID do Aluguel
    public Optional<AluguelEspaco> findAluguelEspacoById(int idAluguel) {
        return aluguelEspacoRepository.findAluguelEspacoById(idAluguel);
    }

    // Método para buscar associações Aluguel-Espaço por tempo de aluguel
    public List<AluguelEspaco> findAluguelEspacosByTempoAluguel(String tempoAluguel) {
        return aluguelEspacoRepository.findAluguelEspacosByTempoAluguel(tempoAluguel);
    }
}