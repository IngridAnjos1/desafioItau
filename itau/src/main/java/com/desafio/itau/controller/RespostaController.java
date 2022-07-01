package com.desafio.itau.controller;

import com.desafio.itau.model.entidades.Comentario;
import com.desafio.itau.model.entidades.Resposta;
import com.desafio.itau.model.entidades.Usuario;
import com.desafio.itau.model.services.RespostaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("respostas")
@RestController
@AllArgsConstructor
public class RespostaController {

    private RespostaService respostaService;

    @PostMapping
    public Resposta salvar(@RequestBody Resposta resposta){
        return respostaService.salvar(resposta);
    }

    @GetMapping("/{id}")
    public Resposta buscarResposta(@PathVariable Long id){
        return respostaService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String deletarResposta(@PathVariable Long id){
        return respostaService.deletar(id);
    }

    @PutMapping
    public Resposta atualizarResposta(@RequestBody Resposta resposta){
        return respostaService.atualizar(resposta);
    }
}
