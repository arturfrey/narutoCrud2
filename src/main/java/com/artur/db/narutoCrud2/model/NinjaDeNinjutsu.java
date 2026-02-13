package com.artur.db.narutoCrud2.model;

import com.artur.db.narutoCrud2.interfaces.Ninja;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NINJUTSU")
public class NinjaDeNinjutsu extends Personagem implements Ninja {

    @Override
    public void usarJutsu(String nomeJutsu, Personagem inimigo) {

        Jutsu jutsu = getJutsus().get(nomeJutsu);

        if (jutsu == null) {
            System.out.println(getNome() + " tentou usar um jutsu inexistente.");
            return;
        }

        if (getChakra() < jutsu.getConsumoDeChakra()) {
            System.out.println(getNome() + " não tem chakra suficiente para atacar.");
            return;
        }

        if (inimigo.getVida() <= 0) {
            System.out.println(inimigo.getNome() + " já foi derrotado.");
            return;
        }

        setChakra(getChakra() - jutsu.getConsumoDeChakra());

        inimigo.setVida(Math.max(0, inimigo.getVida() - jutsu.getDano()));

        System.out.println(
                getNome() + " usou o Ninjutsu " + nomeJutsu +
                        " causando " + jutsu.getDano() + " de dano em " + inimigo.getNome()
        );
    }

    @Override
    public void desviar(int dano) {

        boolean sucesso = Math.random() < 0.5;

        if (sucesso) {
            System.out.println(getNome() + " desviou do ataque e não sofreu dano.");
        } else {
            setVida(getVida() - dano);
            System.out.println(getNome() + " falhou ao desviar e sofreu " + dano + " de dano.");
        }
    }
}
