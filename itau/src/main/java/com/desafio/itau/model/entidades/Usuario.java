package com.desafio.itau.model.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonIgnore
    private String senha;
    @OneToMany(
            mappedBy = "usuario"
    )
    @JsonIgnore
    private List<Comentario> comentarios = new ArrayList<>();
    @OneToMany(
            mappedBy = "usuario"
    )
    @JsonIgnore
    private List<Nota> notas = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles")
    private Set<Integer> roles = new HashSet<>();
    @OneToMany(
            mappedBy = "usuario"
    )
    @JsonIgnore
    private List<Resposta> respostas = new ArrayList<>();
    private Integer pontos = 0;

    public Set<Role> getRoles() {
        return roles.stream().map(Role::toEnum).collect(Collectors.toSet());
    }

    public void addRole(Role role) {
        roles.add(role.getValor());
    }

    public void adicionaPontos() {
        ++pontos;
    }

    public void verificaPerfil() {
        if (this.pontos > 0 && this.pontos < 20) {
            addRole(Role.LEITOR);
        } else if (this.pontos >= 20 && this.pontos < 100) {
            addRole(Role.BASICO);
        } else if (this.pontos >= 100 && this.pontos < 1000) {
            addRole(Role.AVANCADO);
        } else {
            addRole(Role.MODERADOR);
        }
    } ;

}
