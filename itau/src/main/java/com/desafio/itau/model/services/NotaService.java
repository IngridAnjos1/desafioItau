package com.desafio.itau.model.services;

import com.desafio.itau.model.entidades.Filme;
import com.desafio.itau.model.entidades.Nota;
import com.desafio.itau.model.entidades.Usuario;
import com.desafio.itau.model.repository.FilmeRepository;
import com.desafio.itau.model.repository.NotaRepository;
import com.desafio.itau.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;
    private final FilmeRepository filmeRepository;

    public Nota salvar(Nota nota){

        Usuario usuario = usuarioRepository.findById(nota.getUsuario().getId()).get();
        Filme filme =  filmeRepository.findById(nota.getFilme().getId()).get();
        nota.setUsuario(usuario);
        nota.setFilme(filme);
        filme.getNotas().add(nota);
        usuario.getNotas().add(nota);
        usuario.adicionaPontos();
        usuario.verificaPerfil();
        filme.calcularAvaliacao(nota.getNota());

        usuarioRepository.save(usuario);
        filmeRepository.save(filme);

        return notaRepository.save(nota);
    }

    public Nota buscar(Long id) {
        return notaRepository.findById(id).get();
    }

    public String deletar(Long id) {
        notaRepository.deleteById(id);
        return "Nota deletada";
    }

    public Nota atualizar(Nota nota) {
        return notaRepository.save(nota);
    }
}
