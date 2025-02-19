package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.CategoriaLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaLivroRepository extends JpaRepository<CategoriaLivro, Integer> {

    // Consulta personalizada para buscar todas as associações Categoria-Livro
    @Query("SELECT cl FROM CategoriaLivro cl")
    List<CategoriaLivro> findAllCategoriaLivro();

    // Consulta personalizada para buscar associações por ID da Categoria
    @Query("SELECT cl FROM CategoriaLivro cl WHERE cl.categoria.idCategoria = :idCategoria")
    List<CategoriaLivro> findByCategoriaId(int idCategoria);

    // Consulta personalizada para buscar associações por ID do Livro
    @Query("SELECT cl FROM CategoriaLivro cl WHERE cl.livro.idLivro = :idLivro")
    List<CategoriaLivro> findByLivroId(int idLivro);
}