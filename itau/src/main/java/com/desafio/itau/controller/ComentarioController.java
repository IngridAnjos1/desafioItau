package com.desafio.itau.controller;

import com.desafio.itau.model.entidades.Comentario;
import com.desafio.itau.model.services.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("comentarios")
@RestController
@AllArgsConstructor
public class ComentarioController {

    private ComentarioService comentarioService;

    @PostMapping
    public Comentario salvar(@RequestBody Comentario comentario){
        return comentarioService.salvar(comentario);
    }

    @GetMapping("/{id}")
    public Comentario buscarComentario(@PathVariable Long id){
        return comentarioService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String deletarComentario(@PathVariable Long id){
        return comentarioService.deletar(id);
    }

    @PutMapping
    public Comentario atualizarComentario(@RequestBody Comentario comentario){
        return comentarioService.atualizar(comentario);
    }

}
