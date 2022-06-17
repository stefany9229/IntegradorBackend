package com.example.Integrador2.model;

public class Odontologo {

    private Integer matricula;
    private String nombre;
    private String apellido;
    private Integer id;

    public Odontologo(Integer matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int id,Integer numeroMatricula, String nombre, String apellido) {
        this.matricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id=id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id=" + id +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getId() {
        return id;
    }


    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

