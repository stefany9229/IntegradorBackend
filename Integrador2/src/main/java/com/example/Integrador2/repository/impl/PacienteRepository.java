package com.example.Integrador2.repository.impl;

import com.example.Integrador2.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
