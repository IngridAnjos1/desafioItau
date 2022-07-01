package com.desafio.itau.model.services;

import com.desafio.itau.model.entidades.Role;
import com.desafio.itau.model.entidades.Usuario;
import com.desafio.itau.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario){
        if (usuario.getRoles().size() == 0)usuario.addRole(Role.LEITOR);
        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public String deletar(Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario Deletado";
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
