package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.EdicaoLivro;
import com.example.sistema_livraria.repositories.EdicaoLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdicaoLivroService {

    @Autowired
    private EdicaoLivroRepository edicaoLivroRepository;

    // Método para salvar uma associação Edicao-Livro
    public EdicaoLivro saveEdicaoLivro(EdicaoLivro edicaoLivro) {
        return edicaoLivroRepository.save(edicaoLivro);
    }

    // Método para buscar todas as associações Edicao-Livro
    public List<EdicaoLivro> findAllEdicaoLivro() {
        return edicaoLivroRepository.findAllEdicaoLivro();
    }

    // Método para buscar associações por ID da Edicao
    public List<EdicaoLivro> findByEdicaoId(int idEdicao) {
        return edicaoLivroRepository.findByEdicaoId(idEdicao);
    }

    // Método para buscar associações por ID do Livro
    public List<EdicaoLivro> findByLivroId(int idLivro) {
        return edicaoLivroRepository.findByLivroId(idLivro);
    }
}