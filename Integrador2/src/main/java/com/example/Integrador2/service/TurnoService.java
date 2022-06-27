package com.example.Integrador2.service;

import com.example.Integrador2.repository.IDao;

import com.example.Integrador2.model.Turno;

import java.util.List;


public class TurnoService {



    private IDao<Turno> turnoDao;

    public TurnoService(IDao<Turno> turnoDao){
        this.turnoDao=turnoDao;
    }

    List<Turno> buscarTurnos(){
        return turnoDao.buscarTodos();
    }

    Turno registrarTurno(Turno turno){
        return turnoDao.guardar(turno);
    }

    Turno actulizarTruno (Turno turno){
        return turnoDao.actualizar(turno);
    }

    void  actulizarTurno(Integer id){
        turnoDao.actualizar(turnoDao.buscar(id));
    }

    Turno buscarTurnoxId(Integer id){
        return turnoDao.buscar(id);
    }
}
