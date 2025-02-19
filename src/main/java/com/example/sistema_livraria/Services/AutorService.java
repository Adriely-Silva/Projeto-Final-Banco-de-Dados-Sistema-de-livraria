package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Autor;
import com.example.sistema_livraria.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Método para salvar um autor
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    // Método para buscar todos os autores
    public List<Autor> findAllAutores() {
        return autorRepository.findAllAutores();
    }

    // Método para buscar um autor por ID
    public Optional<Autor> findAutorById(int idAutor) {
        return autorRepository.findAutorById(idAutor);
    }

    // Método para buscar autores por nome
    public List<Autor> findAutoresByNome(String nomeAutor) {
        return autorRepository.findAutoresByNome(nomeAutor);
    }
}