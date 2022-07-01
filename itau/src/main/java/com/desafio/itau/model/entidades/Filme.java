package com.desafio.itau.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFilme;
    private String descricao;
    private double avaliacao = 0.00;
    private int contador = 0;
    private int totalDasNotas;
    @JsonIgnore


    @OneToMany(
            mappedBy = "filme"
    )
    private List<Comentario> comentarios = new ArrayList<>();
    @JsonIgnore
    @OneToMany(
            mappedBy = "filme"
    )
        private List<Nota> notas = new ArrayList<>();


    public double calcularAvaliacao(int nota){
        this.totalDasNotas = this.totalDasNotas + nota;
        ++this.contador;
        return this.avaliacao= ((double) this.totalDasNotas/this.contador);
    }
}
