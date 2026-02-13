package com.artur.db.narutoCrud2.ModelTests;

import com.artur.db.narutoCrud2.model.Jutsu;
import com.artur.db.narutoCrud2.model.NinjaDeNinjutsu;
import com.artur.db.narutoCrud2.model.Personagem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NinjaDeNinjutsuTest {

    @Test
    void deveUsarJutsuCorretamente(){
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        Personagem inimigo = new Personagem();

        Jutsu rasengan = new Jutsu(30, 20);
        ninja.adicionarJutsu("rasengan", rasengan);
        ninja.usarJutsu("rasengan", inimigo);

        assertEquals(70, inimigo.getVida());
        assertEquals(80, ninja.getChakra());
    }

    @Test
    void deveDesviarCorretamente(){
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();

        Jutsu rasengan = new Jutsu(30, 20);
        ninja.adicionarJutsu("rasengan", rasengan);

        boolean desviou = false;
        boolean levouDano = false;

        while (!desviou) {
            ninja.setVida(100);
            ninja.desviar(rasengan.getDano());

            if (ninja.getVida() == 100) desviou = true;
        }

        while (!levouDano) {
            ninja.setVida(100);
            ninja.desviar(rasengan.getDano());
            if (ninja.getVida() == 70) levouDano = true;
        }

        assertTrue(desviou);
        assertTrue(levouDano);
    }
}
