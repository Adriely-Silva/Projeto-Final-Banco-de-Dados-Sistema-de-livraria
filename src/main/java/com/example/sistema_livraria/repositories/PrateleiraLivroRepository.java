package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.PrateleiraLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrateleiraLivroRepository extends JpaRepository<PrateleiraLivro, Integer> {

    // Consulta personalizada para buscar todas as associações Prateleira-Livro
    @Query("SELECT pl FROM PrateleiraLivro pl")
    List<PrateleiraLivro> findAllPrateleiraLivro();

    // Consulta personalizada para buscar associações por ID da Prateleira
    @Query("SELECT pl FROM PrateleiraLivro pl WHERE pl.prateleira.idPrat = :idPrat")
    List<PrateleiraLivro> findByPrateleiraId(int idPrat);

    // Consulta personalizada para buscar associações por ID do Livro
    @Query("SELECT pl FROM PrateleiraLivro pl WHERE pl.livro.idLivro = :idLivro")
    List<PrateleiraLivro> findByLivroId(int idLivro);
}