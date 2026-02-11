package com.artur.db.narutoCrud2.repository;

import com.artur.db.narutoCrud2.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}

