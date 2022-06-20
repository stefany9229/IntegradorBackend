package com.example.Integrador2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionDB {



    public ConfiguracionDB() {
    }

    public static Connection connection(){

        String DB_JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
        String DB_USER ="sa";
        String DB_PASSWORD = "sa";

        Connection connection = null;
        try {
            System.out.println("entro al try");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public Connection connection(String DB_JDBC_DRIVER, String DB_URL,String DB_USER, String DB_PASSWORD){
        Connection connection = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }


}
