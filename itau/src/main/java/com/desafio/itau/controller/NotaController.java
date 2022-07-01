package com.desafio.itau.controller;

import com.desafio.itau.model.entidades.Comentario;
import com.desafio.itau.model.entidades.Nota;
import com.desafio.itau.model.entidades.Usuario;
import com.desafio.itau.model.services.NotaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("notas")
@RestController
@AllArgsConstructor
public class NotaController {

    private NotaService notaService;

    @PostMapping
    public Nota salvar(@RequestBody Nota nota){
        return notaService.salvar(nota);
    }

    @GetMapping("/{id}")
    public Nota buscarNota(@PathVariable Long id){
        return notaService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String deletarNota(@PathVariable Long id){
        return notaService.deletar(id);
    }

    @PutMapping
    public Nota atualizarNota(@RequestBody Nota nota){
        return notaService.atualizar(nota);
    }
}
