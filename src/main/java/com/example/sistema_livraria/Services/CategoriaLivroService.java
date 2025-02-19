package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.CategoriaLivro;
import com.example.sistema_livraria.repositories.CategoriaLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaLivroService {

    @Autowired
    private CategoriaLivroRepository categoriaLivroRepository;

    // Método para salvar uma associação Categoria-Livro
    public CategoriaLivro saveCategoriaLivro(CategoriaLivro categoriaLivro) {
        return categoriaLivroRepository.save(categoriaLivro);
    }

    // Método para buscar todas as associações Categoria-Livro
    public List<CategoriaLivro> findAllCategoriaLivro() {
        return categoriaLivroRepository.findAllCategoriaLivro();
    }

    // Método para buscar associações por ID da Categoria
    public List<CategoriaLivro> findByCategoriaId(int idCategoria) {
        return categoriaLivroRepository.findByCategoriaId(idCategoria);
    }

    // Método para buscar associações por ID do Livro
    public List<CategoriaLivro> findByLivroId(int idLivro) {
        return categoriaLivroRepository.findByLivroId(idLivro);
    }
}