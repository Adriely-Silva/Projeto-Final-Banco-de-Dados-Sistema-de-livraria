package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Gerente;
import com.example.sistema_livraria.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;


    // Método para inserir um gerente usando query nativa
    public void insertGerente(int idFunc, String tipoFunc) {
        gerenteRepository.insertGerente(idFunc, tipoFunc);
    }

    // Método para deletar um gerente por ID usando query nativa
    public void deleteGerenteById(int idFunc) {
        gerenteRepository.deleteGerenteById(idFunc);
    }

    // Método para salvar um gerente
    public Gerente saveGerente(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    // Método para buscar todos os gerentes
    public List<Gerente> findAllGerentes() {
        return gerenteRepository.findAllGerentes();
    }

    // Método para buscar um gerente por ID
    public Optional<Gerente> findGerenteById(int idFunc) {
        return gerenteRepository.findGerenteById(idFunc);
    }

    // Método para buscar gerentes por tipo
    public List<Gerente> findGerentesByTipo(String tipoFunc) {
        return gerenteRepository.findGerentesByTipo(tipoFunc);
    }
}