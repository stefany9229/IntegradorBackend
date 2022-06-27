package com.example.Integrador2.service;

import com.example.Integrador2.model.Paciente;
import com.example.Integrador2.repository.IDao;
import com.example.Integrador2.model.Odontologo;
import com.example.Integrador2.repository.impl.OdontologoRepository;
import com.example.Integrador2.repository.impl.PacienteRepository;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo o) {
        return odontologoRepository.save(o);
    }


    public Odontologo buscar(Integer id) {
        return odontologoRepository.findById(id).get();
    }

    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    public void eliminar(Integer id) { odontologoRepository.deleteById(id); }

    public Odontologo actualizar(Odontologo o) {

        Odontologo paciente_=odontologoRepository.findById(o.getId()).get();

        return odontologoRepository.save(paciente_);
    }
}


