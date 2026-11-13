package com.ito.OPGFact4_t4.controller;

import com.ito.OPGFact4_t4.dto.JugadorDTO;
import com.ito.OPGFact4_t4.entity.Jugador;
import com.ito.OPGFact4_t4.service.JugadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<JugadorDTO>> getAll() {
        List<Jugador> jugadoresBD = jugadorService.getJugadores();
        List<JugadorDTO> listaDTOs = new ArrayList<>();

        for (Jugador j : jugadoresBD) {
            JugadorDTO dto = new JugadorDTO();
            dto.setId(j.getId());
            dto.setNombre(j.getNombre());
            dto.setApellidos(j.getApellidos());
            dto.setEmail(j.getEmail());
            dto.setPosicion(j.getPosicion());

            listaDTOs.add(dto);
        }

        return ResponseEntity.ok(listaDTOs);
    }

    @PostMapping
    public ResponseEntity<JugadorDTO> create(@Valid @RequestBody JugadorDTO dto) {
        Jugador jugador = new Jugador();
        jugador.setNombre(dto.getNombre());
        jugador.setApellidos(dto.getApellidos());
        jugador.setEmail(dto.getEmail());
        jugador.setPosicion(dto.getPosicion());

        jugadorService.saveOrUpdate(jugador);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{jugadorId}")
    public ResponseEntity<JugadorDTO> update(@PathVariable("jugadorId") Long jugadorId,
            @Valid @RequestBody JugadorDTO dto) {
        Jugador jugador = new Jugador();
        jugador.setId(jugadorId);
        jugador.setNombre(dto.getNombre());
        jugador.setApellidos(dto.getApellidos());
        jugador.setEmail(dto.getEmail());
        jugador.setPosicion(dto.getPosicion());

        jugadorService.saveOrUpdate(jugador);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{jugadorId}")
    public ResponseEntity<String> delete(@PathVariable("jugadorId") Long jugadorId) {
        jugadorService.delete(jugadorId);
        return ResponseEntity.ok("Jugador eliminado correctamente");
    }
}