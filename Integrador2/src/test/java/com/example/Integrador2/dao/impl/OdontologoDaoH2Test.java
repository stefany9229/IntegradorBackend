package com.example.Integrador2.dao.impl;

import com.example.Integrador2.service.OdontologoService;
import com.example.Integrador2.model.Odontologo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDaoH2Test {

    private OdontologoService odontolgoService= new OdontologoService(new OdontologoDaoH2());


    @Test
    void guardar() {

        Odontologo odontologo= new Odontologo(1234,"Franco","Reyes");
        odontolgoService.guardar(odontologo);

        Assert.assertNotNull(odontolgoService.buscar(2));
    }

    @Test
    void buscar() {

        Assert.assertNotNull(odontolgoService.buscar(1));
    }

    @Test
    void eliminar() {
        odontolgoService.eliminar(8);
        Assert.assertNull(odontolgoService.buscar(8));

    }

    @Test
    void buscarTodos() {
    }

    @Test
    void actualizar() {
        Odontologo odontologo1= new Odontologo(5,2345,"Carlos","Perez");
        odontolgoService.actualizar(odontologo1);
        Assert.assertEquals(odontologo1,odontolgoService.buscar(5));

    }
}