package com.artur.db.narutoCrud2.service;

import com.artur.db.narutoCrud2.model.NinjaDeNinjutsu;
import com.artur.db.narutoCrud2.model.NinjaDeTaijutsu;
import com.artur.db.narutoCrud2.model.Personagem;
import com.artur.db.narutoCrud2.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    private final PersonagemRepository repository;

    public PersonagemService(PersonagemRepository repository) {
        this.repository = repository;
    }

    public Personagem criarPersonagem(String nome) {
        Personagem personagem = new Personagem(nome);
        return repository.save(personagem);
    }

    public NinjaDeNinjutsu criarNinjaDeNinjutsu(String nome) {
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        ninja.setNome(nome);
        return repository.save(ninja);
    }

    public NinjaDeTaijutsu criarNinjaDeTaijutsu(String nome) {
        NinjaDeTaijutsu ninja = new NinjaDeTaijutsu();
        ninja.setNome(nome);
        return repository.save(ninja);
    }
}

