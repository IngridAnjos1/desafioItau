package com.desafio.itau.model.services;

import com.desafio.itau.model.entidades.Filme;
import com.desafio.itau.model.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FilmeService {

    @Autowired
    private final FilmeRepository filmeRepository;

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }

    public Filme buscar(Long id){
        return filmeRepository.findById(id).get();
    }

    public String deletar(Long id) {
        filmeRepository.deleteById(id);
        return "Filme deletado";
    }

    public Filme atualizar(Filme filme) {
        return filmeRepository.save(filme);
    }
}
