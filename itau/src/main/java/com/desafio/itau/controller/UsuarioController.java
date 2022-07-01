package com.desafio.itau.controller;

import com.desafio.itau.model.entidades.Comentario;
import com.desafio.itau.model.entidades.Filme;
import com.desafio.itau.model.entidades.Usuario;
import com.desafio.itau.model.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("usuarios")
@RestController
@AllArgsConstructor
public class UsuarioController {


    private  UsuarioService usuarioService;

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id){
        return usuarioService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id){
        return usuarioService.deletar(id);
    }

    @PutMapping
        public Usuario atualizarComentario(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }


}
