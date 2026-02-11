package com.artur.db.narutoCrud2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Transient
    private Map<String, Jutsu> jutsus = new HashMap<>();
    private int chakra = 100;
    private int vida;

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
    }

    public void adicionarJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }
}
