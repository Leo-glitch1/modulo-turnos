package com.api.turnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.turnos.model.EstadoTurno;
import com.api.turnos.model.Turno;
import com.api.turnos.service.EstadoTurnoService;
import com.api.turnos.service.TurnoService;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private EstadoTurnoService estadoTurnoService;

    @PostMapping("/create")
    public ResponseEntity<Turno> createTurno(@RequestBody Turno turno) {
        if (turno.getEstado() == null) {
            // Asigna un estado por defecto
            EstadoTurno estadoPredeterminado = estadoTurnoService.getEstadoById(1L); // Usa un ID válido
            turno.setEstado(estadoPredeterminado);
        }
        Turno savedTurno = turnoService.saveTurno(turno);
        return ResponseEntity.ok(savedTurno);
    }

    // Nuevo método para obtener todos los turnos
    @GetMapping("/view")
    public List<Turno> getAllTurnos() {
        return turnoService.getAllTurnos();
    }

}
