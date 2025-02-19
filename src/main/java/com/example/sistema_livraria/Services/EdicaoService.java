package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Edicao;
import com.example.sistema_livraria.repositories.EdicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdicaoService {

    @Autowired
    private EdicaoRepository edicaoRepository;

    // Método para salvar uma edição
    public Edicao saveEdicao(Edicao edicao) {
        return edicaoRepository.save(edicao);
    }

    // Método para buscar todas as edições
    public List<Edicao> findAllEdicoes() {
        return edicaoRepository.findAllEdicoes();
    }

    // Método para buscar uma edição por ID
    public Optional<Edicao> findEdicaoById(int idEdicao) {
        return edicaoRepository.findEdicaoById(idEdicao);
    }

    // Método para buscar edições por número de edição
    public List<Edicao> findEdicoesByNumEdicao(int numEdicao) {
        return edicaoRepository.findEdicoesByNumEdicao(numEdicao);
    }
}