package com.example.Integrador2.model;

import java.util.Objects;

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
    // se establece el método equals para poder hacer los test
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Odontologo that = (Odontologo) o;
        return Objects.equals(matricula, that.matricula) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nombre, apellido, id);
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

