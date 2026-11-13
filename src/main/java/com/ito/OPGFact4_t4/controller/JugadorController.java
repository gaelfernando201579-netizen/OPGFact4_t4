package com.ito.OPGFact4_t4.controller;

import com.ito.OPGFact4_t4.entity.Jugador;
import com.ito.OPGFact4_t4.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.getJugadores();
    }

    @GetMapping("/{jugadorId}")
    public Optional<Jugador> getById(@PathVariable("jugadorId") Long jugadorId) {
        return jugadorService.getJugador(jugadorId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Jugador jugador) {
        jugadorService.saveOrUpdate(jugador);
    }

    @DeleteMapping("/{jugadorId}")
    public void delete(@PathVariable("jugadorId") Long jugadorId) {
        jugadorService.delete(jugadorId);
    }
}
