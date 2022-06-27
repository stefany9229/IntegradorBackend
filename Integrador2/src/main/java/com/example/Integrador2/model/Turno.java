package com.example.Integrador2.model;

import javax.persistence.*;
import java.util.Date;




@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_secuencia")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id",referencedColumnName = "id")
    private Odontologo odontologo;
    private Date fecha;

    public Turno() {

    }

    public Turno(Integer id, Paciente paciente, Odontologo odontologo, Date fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
