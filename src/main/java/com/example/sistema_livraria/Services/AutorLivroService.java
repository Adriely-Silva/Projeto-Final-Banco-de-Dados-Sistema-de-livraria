package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.AutorLivro;
import com.example.sistema_livraria.repositories.AutorLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorLivroService {

    @Autowired
    private AutorLivroRepository autorLivroRepository;

    // Método para salvar uma associação Autor-Livro
    public AutorLivro saveAutorLivro(AutorLivro autorLivro) {
        return autorLivroRepository.save(autorLivro);
    }

    // Método para buscar todas as associações Autor-Livro
    public List<AutorLivro> findAllAutorLivro() {
        return autorLivroRepository.findAllAutorLivro();
    }

    // Método para buscar associações por ID do Autor
    public List<AutorLivro> findByAutorId(int idAutor) {
        return autorLivroRepository.findByAutorId(idAutor);
    }

    // Método para buscar associações por ID do Livro
    public List<AutorLivro> findByLivroId(int idLivro) {
        return autorLivroRepository.findByLivroId(idLivro);
    }
}