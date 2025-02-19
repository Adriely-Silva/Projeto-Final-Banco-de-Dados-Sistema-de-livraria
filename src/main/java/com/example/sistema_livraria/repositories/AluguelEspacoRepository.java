package com.example.sistema_livraria.repositories;


import com.example.sistema_livraria.models.AluguelEspaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelEspacoRepository extends JpaRepository<AluguelEspaco, Integer> {

    // Consulta personalizada para buscar todas as associações Aluguel-Espaço
    @Query("SELECT ae FROM AluguelEspaco ae")
    List<AluguelEspaco> findAllAluguelEspacos();

    // Consulta personalizada para buscar uma associação Aluguel-Espaço por ID do Aluguel
    @Query("SELECT ae FROM AluguelEspaco ae WHERE ae.idAluguel = :idAluguel")
    Optional<AluguelEspaco> findAluguelEspacoById(int idAluguel);

    // Consulta personalizada para buscar associações Aluguel-Espaço por tempo de aluguel
    @Query("SELECT ae FROM AluguelEspaco ae WHERE ae.tempoAluguel = :tempoAluguel")
    List<AluguelEspaco> findAluguelEspacosByTempoAluguel(String tempoAluguel);
}