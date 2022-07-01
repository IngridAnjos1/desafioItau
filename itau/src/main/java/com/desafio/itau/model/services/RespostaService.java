package com.desafio.itau.model.services;

import com.desafio.itau.model.entidades.*;
import com.desafio.itau.model.repository.ComentarioRepository;
import com.desafio.itau.model.repository.RespostaRepository;
import com.desafio.itau.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ComentarioRepository comentarioRepository;


    public Resposta salvar(Resposta resposta){

        Usuario usuario = usuarioRepository.findById(resposta.getUsuario().getId()).get();
        Comentario comentario =  comentarioRepository.findById(resposta.getComentario().getId()).get();
        resposta.setUsuario(usuario);
        resposta.setComentario(comentario);
        comentario.getRespostas().add(resposta);
        usuario.getRespostas().add(resposta);

        usuarioRepository.save(usuario);
        comentarioRepository.save(comentario);

        return respostaRepository.save(resposta);
    }

    public Resposta buscar(Long id) {
        return respostaRepository.findById(id).get();
    }

    public String deletar(Long id) {
        respostaRepository.deleteById(id);
        return "Resposta deletada";
    }

    public Resposta atualizar(Resposta resposta) {
        return respostaRepository.save(resposta);
    }
}
