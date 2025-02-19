package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.PrateleiraLivro;
import com.example.sistema_livraria.repositories.PrateleiraLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrateleiraLivroService {

    @Autowired
    private PrateleiraLivroRepository prateleiraLivroRepository;

    // Método para salvar uma associação Prateleira-Livro
    public PrateleiraLivro savePrateleiraLivro(PrateleiraLivro prateleiraLivro) {
        return prateleiraLivroRepository.save(prateleiraLivro);
    }

    // Método para buscar todas as associações Prateleira-Livro
    public List<PrateleiraLivro> findAllPrateleiraLivro() {
        return prateleiraLivroRepository.findAllPrateleiraLivro();
    }

    // Método para buscar associações por ID da Prateleira
    public List<PrateleiraLivro> findByPrateleiraId(int idPrat) {
        return prateleiraLivroRepository.findByPrateleiraId(idPrat);
    }

    // Método para buscar associações por ID do Livro
    public List<PrateleiraLivro> findByLivroId(int idLivro) {
        return prateleiraLivroRepository.findByLivroId(idLivro);
    }
}