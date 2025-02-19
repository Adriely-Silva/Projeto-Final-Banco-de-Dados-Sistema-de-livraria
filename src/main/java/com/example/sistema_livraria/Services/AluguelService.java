package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Aluguel;
import com.example.sistema_livraria.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    // Método para salvar um aluguel
    public Aluguel saveAluguel(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    // Método para buscar todos os aluguéis
    public List<Aluguel> findAllAlugueis() {
        return aluguelRepository.findAllAlugueis();
    }

    // Método para buscar um aluguel por ID
    public Optional<Aluguel> findAluguelById(int idAluguel) {
        return aluguelRepository.findAluguelById(idAluguel);
    }

    // Método para buscar aluguéis por data
    public List<Aluguel> findAlugueisByData(LocalDateTime data) {
        return aluguelRepository.findAlugueisByData(data);
    }

    // Método para buscar aluguéis com valor maior que um valor
    public List<Aluguel> findAlugueisByValorGreaterThan(double valor) {
        return aluguelRepository.findAlugueisByValorGreaterThan(valor);
    }
}