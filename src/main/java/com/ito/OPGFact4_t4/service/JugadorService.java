package com.ito.OPGFact4_t4.service;

import com.ito.OPGFact4_t4.entity.Jugador;
import com.ito.OPGFact4_t4.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    JugadorRepository jugadorRepository;

    public List<Jugador> getJugadores() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> getJugador(Long id) {
        return jugadorRepository.findById(id);
    }

    public void saveOrUpdate(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

    public void delete(Long id) {
        jugadorRepository.deleteById(id);
    }
}
