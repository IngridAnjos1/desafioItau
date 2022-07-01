package com.desafio.itau.model.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Role {
    LEITOR(0, "ROLE_LEITOR"),
    BASICO(1, "ROLE_BASICO"),
    AVANCADO(2, "ROLE_AVANCADO"),
    MODERADOR(3, "ROLE_MODERADOR");

    private final int valor;
    private final String nome;

    public static Role toEnum(Integer valor) {
        if (valor == null) return null;

        return Arrays.stream(Role.values()).filter(role -> {
            return valor.equals(role.getValor());
        }).findFirst().orElseThrow(
                () -> new IllegalArgumentException("Id inválido: " + valor)
        );
    }


}