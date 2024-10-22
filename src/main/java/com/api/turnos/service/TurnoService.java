package com.api.turnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.turnos.model.Turno;
import com.api.turnos.repository.TurnoRepository;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    // Método para obtener todos los turnos
    public List<Turno> getAllTurnos() {
        return turnoRepository.findAll();
    }

    // Método para obtener un turno por su ID
    public Optional<Turno> getTurnoById(Long id) {
        return turnoRepository.findById(id);
    }

    // Método para guardar un turno
    public Turno saveTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    // Método para eliminar un turno por su ID
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
