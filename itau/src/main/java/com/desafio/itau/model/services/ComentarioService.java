package com.desafio.itau.model.services;

import com.desafio.itau.model.entidades.Comentario;
import com.desafio.itau.model.entidades.Filme;
import com.desafio.itau.model.entidades.Usuario;
import com.desafio.itau.model.repository.ComentarioRepository;
import com.desafio.itau.model.repository.FilmeRepository;
import com.desafio.itau.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ComentarioService {

    @Autowired
    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final FilmeRepository filmeRepository;

    public Comentario salvar(Comentario comentario){

        Usuario usuario = usuarioRepository.findById(comentario.getUsuario().getId()).get();
        Filme filme =  filmeRepository.findById(comentario.getUsuario().getId()).get();
        comentario.setUsuario(usuario);
        comentario.setFilme(filme);
        filme.getComentarios().add(comentario);
        usuario.getComentarios().add(comentario);
        usuario.adicionaPontos();
        usuario.verificaPerfil();

        usuarioRepository.save(usuario);
        filmeRepository.save(filme);

        return comentarioRepository.save(comentario);
    }

    public Comentario buscar(Long id) {
        return comentarioRepository.findById(id).get();
    }

    public Comentario atualizar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public String deletar(Long id) {
        comentarioRepository.deleteById(id);
        return "Comentário deletado";
    }
}
