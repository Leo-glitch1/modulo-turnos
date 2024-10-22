package com.api.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.turnos.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
