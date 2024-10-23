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
import com.api.turnos.model.Sucursal;
import com.api.turnos.model.Turno;
import com.api.turnos.service.EstadoTurnoService;
import com.api.turnos.service.SucursalService;
import com.api.turnos.service.TurnoService;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private EstadoTurnoService estadoTurnoService;

    @Autowired
    private SucursalService sucursalService; // Inyecta SucursalService aquí

    @PostMapping("/create")
    public ResponseEntity<Turno> createTurno(@RequestBody Turno turno) {
        // Verifica si el estado es nulo y asigna un estado por defecto
        if (turno.getEstado() == null) {
            EstadoTurno estadoPredeterminado = estadoTurnoService.getEstadoById(1L); // Usa un ID válido
            turno.setEstado(estadoPredeterminado);
        }

        // Verifica si la sucursal es nula y asigna una sucursal por defecto
        if (turno.getSucursal() == null) {
            Sucursal sucursalPorDefecto = sucursalService.getSucursalById(1L); // Usa un ID válido
            turno.setSucursal(sucursalPorDefecto);
        }

        // Guarda el turno
        Turno savedTurno = turnoService.saveTurno(turno);
        return ResponseEntity.ok(savedTurno);
    }

    // Nuevo método para obtener todos los turnos
    @GetMapping("/view")
    public List<Turno> getAllTurnos() {
        return turnoService.getAllTurnos();
    }
}
