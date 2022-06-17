package com.example.Integrador2.dao.impl;


import com.example.Integrador2.dao.ConfiguracionDB;
import com.example.Integrador2.dao.IDao;
import com.example.Integrador2.model.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    ConfiguracionDB ConfiguracionBD= new ConfiguracionDB();





    @Override
    public Domicilio guardar(Domicilio domicilio) {

            PreparedStatement preparedStatement = null;

            try {

                //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
                preparedStatement = ConfiguracionBD.connection().prepareStatement("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
                //preparedStatement.setInt(1,domicilio.getId());
                preparedStatement.setString(1, domicilio.getCalle());
                preparedStatement.setString(2, domicilio.getNumero());
                preparedStatement.setString(3, domicilio.getLocalidad());
                preparedStatement.setString(4, domicilio.getProvincia());

                //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
                preparedStatement.executeUpdate();
                ResultSet keys = preparedStatement.getGeneratedKeys();
                if(keys.next())
                    domicilio.setId(keys.getInt(1));

                preparedStatement.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return domicilio;

    }

    @Override
    public void eliminar(Integer id) {

        PreparedStatement preparedStatement = null;
        try {
        ;

            //2 Crear una sentencia
            preparedStatement =ConfiguracionBD.connection().prepareStatement("DELETE FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Domicilio buscar(Integer id) {

        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;
        try {

            //2 Crear una sentencia
            preparedStatement = ConfiguracionBD.connection().prepareStatement("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try {


            //2 Crear una sentencia
            preparedStatement = ConfiguracionBD.connection().prepareStatement("SELECT *  FROM domicilios");

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {

                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                Domicilio domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);

                domicilios.add(domicilio);

            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilios;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {


             preparedStatement = ConfiguracionBD.connection().prepareStatement("UPDATE domicilios SET calle = ?, numero = ? ,localidad = ?, provincia = ?  WHERE id = ?");
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilio;
    }
}

