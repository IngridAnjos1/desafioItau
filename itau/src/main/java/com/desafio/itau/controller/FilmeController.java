package com.desafio.itau.controller;

import com.desafio.itau.model.entidades.Comentario;
import com.desafio.itau.model.entidades.Filme;
import com.desafio.itau.model.services.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("filmes")
@RestController
@AllArgsConstructor
public class FilmeController {

    private FilmeService filmeService;

    @PostMapping
    public Filme salvarFilme(@RequestBody Filme filme){
        return filmeService.salvar(filme);
    }

    @GetMapping("/{id}")
    public Filme buscarFilme(@PathVariable Long id){
        return filmeService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String deletarFilme(@PathVariable Long id){
        return filmeService.deletar(id);
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme filme){
        return filmeService.atualizar(filme);
    }
}
