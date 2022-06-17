package com.example.Integrador2.service;



import com.example.Integrador2.dao.IDao;
import com.example.Integrador2.dao.impl.PacienteDaoH2;
import com.example.Integrador2.model.Paciente;

import java.util.Date;
import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(PacienteDaoH2 pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteIDao.guardar(p);
    }

    public Paciente buscar(Integer id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }

    public void eliminar(Integer id) {
        pacienteIDao.eliminar(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteIDao.actualizar(p);
    }
}
