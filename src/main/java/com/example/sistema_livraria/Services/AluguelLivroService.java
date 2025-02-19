package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.AluguelLivro;
import com.example.sistema_livraria.repositories.AluguelLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelLivroService {

    @Autowired
    private AluguelLivroRepository aluguelLivroRepository;

    // Método para salvar uma associação Aluguel-Livro
    public AluguelLivro saveAluguelLivro(AluguelLivro aluguelLivro) {
        return aluguelLivroRepository.save(aluguelLivro);
    }

    // Método para buscar todas as associações Aluguel-Livro
    public List<AluguelLivro> findAllAluguelLivros() {
        return aluguelLivroRepository.findAllAluguelLivros();
    }

    // Método para buscar uma associação Aluguel-Livro por ID do Aluguel
    public Optional<AluguelLivro> findAluguelLivroById(int idAluguel) {
        return aluguelLivroRepository.findAluguelLivroById(idAluguel);
    }

    // Método para buscar associações Aluguel-Livro por data de devolução
    public List<AluguelLivro> findAluguelLivrosByDataDevolucao(LocalDateTime dataDevolucao) {
        return aluguelLivroRepository.findAluguelLivrosByDataDevolucao(dataDevolucao);
    }
}