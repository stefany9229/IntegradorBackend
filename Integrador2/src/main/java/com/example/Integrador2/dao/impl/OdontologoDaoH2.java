package com.example.Integrador2.dao.impl;

import com.example.Integrador2.dao.ConfiguracionDB;
import com.example.Integrador2.dao.IDao;
import com.example.Integrador2.model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        //3 Se crea la sentencia para insertar el nuevo registro apartir el odontologo Recibido

        String SQL_INSERT= "insert into odontologos values(default,?,?,?);";

        //  preparo el drive y la conexion


        PreparedStatement preparedStatement=null;

        try {


            preparedStatement= ConfiguracionDB.connection().prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1,odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();


        }


        return odontologo;
    }


    @Override
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        //preparpo el Statement y la cosulta
        PreparedStatement preparedStatement= null;
        ResultSet result=null;
        List<Odontologo>listaOdontologos=new ArrayList<>();

        try {

            String SQL_QUERY_ALL="select * from odontologos;";
            preparedStatement= ConfiguracionDB.connection().prepareStatement(SQL_QUERY_ALL);
            result = preparedStatement.executeQuery();


            //3 Recorro y creo los nuevo medicos para agregar a la lista

            while(result.next()){

                Odontologo odontologo = new Odontologo(result.getInt("id"),
                        result.getInt("matricula"),
                        result.getString("nombre" ),
                        result.getString("apellido"));

                listaOdontologos.add(odontologo);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }


        return listaOdontologos;

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}
