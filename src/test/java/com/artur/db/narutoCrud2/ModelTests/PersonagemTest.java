package com.artur.db.narutoCrud2.ModelTests;

import com.artur.db.narutoCrud2.model.Jutsu;
import com.artur.db.narutoCrud2.model.Personagem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    @Test
    void deveAdicionarJutsu(){
        Personagem personagem = new Personagem();
        Jutsu rasengan = new Jutsu(30, 20);

        personagem.adicionarJutsu("rasengan", rasengan);

        assertEquals(1, personagem.getJutsus().size());
        assertEquals(rasengan, personagem.getJutsus().get("rasengan"));
    }

    @Test
    void deveAtacarInimigo(){
        Personagem atacante = new Personagem("Naruto");
        Personagem inimigo = new Personagem("Sasuke");

        atacante.atacar(inimigo);

        assertEquals(90, inimigo.getVida());
    }
}
