package com.api.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.turnos.model.EstadoTurno;

public interface EstadoTurnoRepository extends JpaRepository<EstadoTurno, Long> {

}
