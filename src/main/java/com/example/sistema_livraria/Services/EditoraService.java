package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Editora;
import com.example.sistema_livraria.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    // Método para salvar uma editora
    public Editora saveEditora(Editora editora) {
        return editoraRepository.save(editora);
    }

    // Método para buscar todas as editoras
    public List<Editora> findAllEditoras() {
        return editoraRepository.findAllEditoras();
    }

    // Método para buscar uma editora por ID
    public Optional<Editora> findEditoraById(int idEditora) {
        return editoraRepository.findEditoraById(idEditora);
    }

    // Método para buscar editoras por nome
    public List<Editora> findEditorasByNome(String nomeEditora) {
        return editoraRepository.findEditorasByNome(nomeEditora);
    }
}