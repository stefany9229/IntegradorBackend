package com.example.Integrador2;

import com.example.Integrador2.dao.ConfiguracionDB;
import com.example.Integrador2.dao.impl.OdontologoDaoH2;
import com.example.Integrador2.model.Odontologo;
import com.example.Integrador2.service.OdontologoService;
import com.example.Integrador2.dao.ConfiguracionDB;

import java.sql.SQLException;

public class mainFalso {

    public static void main(String[] args) throws SQLException {
        OdontologoService odontolgoService= new OdontologoService(new OdontologoDaoH2());

       /* Odontologo odontologo= new Odontologo(1234,"Carlos","Baez");
        odontolgoService.guardar(odontologo);
        odontolgoService.buscar(1234);*/

        System.out.println(odontolgoService.buscar(5));




    }
}
