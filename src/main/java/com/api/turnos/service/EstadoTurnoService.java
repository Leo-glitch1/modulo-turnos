package com.api.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.turnos.model.EstadoTurno;
import com.api.turnos.repository.EstadoTurnoRepository;
// En EstadoTurnoService.java
@Service
public class EstadoTurnoService {

    @Autowired
    private EstadoTurnoRepository estadoTurnoRepository;

    public List<EstadoTurno> getAllEstado() {
        return estadoTurnoRepository.findAll();
    }

    public EstadoTurno getEstadoById(Long id) {
        return estadoTurnoRepository.findById(id).orElse(null);
    }
}

