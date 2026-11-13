package com.ito.OPGFact4_t4.repository;

import com.ito.OPGFact4_t4.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
