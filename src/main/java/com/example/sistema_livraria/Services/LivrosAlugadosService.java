package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.repositories.LivrosAlugadosRepository;
import com.example.sistema_livraria.models.LivrosAlugados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosAlugadosService {

    @Autowired
    private LivrosAlugadosRepository livrosAlugadosRepository;

    // Método para salvar uma associação Livros-Alugados
    public LivrosAlugados saveLivrosAlugados(LivrosAlugados livrosAlugados) {
        return livrosAlugadosRepository.save(livrosAlugados);
    }

    // Método para buscar todas as associações Livros-Alugados
    public List<LivrosAlugados> findAllLivrosAlugados() {
        return livrosAlugadosRepository.findAllLivrosAlugados();
    }

    // Método para buscar associações por ID do Aluguel_Livro
    public List<LivrosAlugados> findByAluguelLivroId(int idAluguel) {
        return livrosAlugadosRepository.findByAluguelLivroId(idAluguel);
    }

    // Método para buscar associações por ID do Livro
    public List<LivrosAlugados> findByLivroId(int idLivro) {
        return livrosAlugadosRepository.findByLivroId(idLivro);
    }
}