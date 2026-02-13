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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Transient
    private Map<String, Jutsu> jutsus = new HashMap<>();
    private int chakra = 100;
    private int vida = 100;

    public Personagem(String nome) {
        this.nome = nome;
    }

    public void adicionarJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }

    public void atacar(Personagem inimigo) {
        if (inimigo.getVida() <= 0) {
            System.out.println(inimigo.getNome() + " já foi derrotado.");
            return;
        }

        inimigo.setVida(Math.max(0, inimigo.getVida() - 10));
        System.out.println(getNome() + " atacou " + inimigo.getNome() + " causando 10 de dano.");
    }
}
