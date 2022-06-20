package com.example.Integrador2.dao.impl;

import com.example.Integrador2.dao.ConfiguracionDB;
import com.example.Integrador2.dao.IDao;
import com.example.Integrador2.model.Domicilio;
import com.example.Integrador2.model.Odontologo;
import com.example.Integrador2.util.Util;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger log = Logger.getLogger(OdontologoDaoH2.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        //3 Se crea la sentencia para insertar el nuevo registro apartir el odontologo Recibido

        String SQL_INSERT= "insert into odontologos values(default,?,?,?);";

        //  preparo el drive y la conexion


        PreparedStatement preparedStatement=null;

        try {


            preparedStatement= ConfiguracionDB.connection().prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                odontologo.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error relacionado con la base de datos",e);


        }


        return odontologo;
    }


    @Override
    public Odontologo buscar(Integer id) {

        PreparedStatement preparedStatement= null;
        ResultSet result=null;
        Odontologo odontologo=null;
        try {
                        //2 preparpo el Statement y la cosulta

            String SQL_QUERY_ONE="select * from odontologos where id=?;";
            preparedStatement=  ConfiguracionDB.connection().prepareStatement(SQL_QUERY_ONE);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeQuery();


            while(result.next()){

                Integer id_= result.getInt("id");
                Integer matricula=result.getInt("matricula");
                String nombre= result.getString("nombre");
                String apellido= result.getString("apellido");

                odontologo= new Odontologo(id_,matricula,nombre,apellido);
            }



        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error relacionado con la base de datos",e);

        }


        return odontologo;



    }

    @Override
    public void eliminar(Integer id) {

        PreparedStatement preparedStatement = null;

        try {

            //2 Crear una sentencia
            preparedStatement = ConfiguracionDB.connection().prepareStatement("DELETE FROM odontologos where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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

        PreparedStatement preparedStatement = null;

        try {

            //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
            preparedStatement =  ConfiguracionDB.connection().prepareStatement("UPDATE odontologos SET id=?, matricula=?, nombre=?, apellido=?  WHERE id = ?");
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,paciente.getId());
            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, odontologo.getMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            //Hay que convertir el Date en sql.Date ya que son dos clases diferentes en Java
            preparedStatement.setString(4, odontologo.getApellido());
            preparedStatement.setInt(5,odontologo.getId() );

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();


            preparedStatement.close();
            ConfiguracionDB.connection().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }





}
