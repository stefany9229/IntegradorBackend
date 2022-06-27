package com.example.Integrador2.repository.impl;

import com.example.Integrador2.repository.IDao;
import com.example.Integrador2.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoDao implements IDao<Turno> {

    private List <Turno> turnos;

    public TurnoDao(){
        turnos = new ArrayList<>();
    }

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;

    }

    @Override
    public Turno buscar(Integer id) {
        Turno turnoBuscado=null;
        for (Turno turno: turnos){
            if (turno.getId().equals(id)){
                turnoBuscado=turno;
                break;
            }
        }
        return  turnoBuscado;
    }

    @Override
    public void eliminar(Integer id) {
        Turno turnoBuscado= this.buscar(id);
        turnos.remove(turnoBuscado);
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        // busco el índice del turno que quiero cambiar
        int indiceTurno= turnos.indexOf(this.buscar(turno.getId()));
        // seteamos el turno aterior por el turno nuevo
        turnos.set(indiceTurno,turno);

        return turno;
    }
}
