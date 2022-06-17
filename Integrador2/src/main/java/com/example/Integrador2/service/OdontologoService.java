package com.example.Integrador2.service;

import com.example.Integrador2.dao.IDao;
import com.example.Integrador2.dao.impl.OdontologoDaoH2;
import com.example.Integrador2.model.Odontologo;
import com.example.Integrador2.model.Paciente;


import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDAO;

    public OdontologoService(OdontologoDaoH2 odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoDAO.guardar(odontologo);
    }

    public Odontologo buscar(Integer matricula) {return odontologoDAO.buscar(matricula);  }

    public List<Odontologo> buscarTodos() {
        return odontologoDAO.buscarTodos();
    }

    public void eliminar(Integer id) {
        odontologoDAO.eliminar(id);
    }

    public Odontologo actualizar(Odontologo o) {
        return odontologoDAO.actualizar(o);
    }
}


