package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Categoria;
import com.example.sistema_livraria.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Método para salvar uma categoria
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Método para buscar todas as categorias
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAllCategorias();
    }

    // Método para buscar uma categoria por ID
    public Optional<Categoria> findCategoriaById(int idCategoria) {
        return categoriaRepository.findCategoriaById(idCategoria);
    }

    // Método para buscar categorias por nome
    public List<Categoria> findCategoriasByNome(String nomeCategoria) {
        return categoriaRepository.findCategoriasByNome(nomeCategoria);
    }
}