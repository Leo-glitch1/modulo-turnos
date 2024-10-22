package com.api.turnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.turnos.model.EstadoTurno;
import com.api.turnos.service.EstadoTurnoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoTurnoController {

    @Autowired
    private EstadoTurnoService estadoTurnoService;

    @GetMapping
    public List<EstadoTurno> getAllEstados() {
        return estadoTurnoService.getAllEstado();
    }
}
