package com.example.Integrador2.service;



import com.example.Integrador2.model.Paciente;
import com.example.Integrador2.repository.impl.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
    public class PacienteService {
        //private IDao<Paciente> pacienteIDao;


        private PacienteRepository pacienteRepository;

        public PacienteService(PacienteRepository pacienteRepository) {
            this.pacienteRepository = pacienteRepository;
        }

        public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteRepository.save(p);
        }

        public Paciente buscar(Integer id) {
            return pacienteRepository.findById(id).get();
        }

        public List<Paciente> buscarTodos() {
            return pacienteRepository.findAll();
        }

        public void eliminar(Integer id) { pacienteRepository.deleteById(id); }

        public Paciente actualizar(Paciente p) {

           Paciente paciente_=pacienteRepository.findById(p.getId()).get();

                return pacienteRepository.save(paciente_);
            }

    }



