package com.artur.db.narutoCrud2.interfaces;

import com.artur.db.narutoCrud2.model.Personagem;

public interface Ninja {

    void usarJutsu(String nomeJutsu, Personagem inimigo);

    void desviar(int danoRecebido);
}
