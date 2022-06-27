package com.example.Integrador2.controller;


import com.example.Integrador2.model.Odontologo;
import com.example.Integrador2.service.OdontologoService;
import com.example.Integrador2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    @Autowired
    private OdontologoService odontologoService;


    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo)) ;
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        //return OdontologoService.actualizar(paciente);
        ResponseEntity<Odontologo> response;
        //Verificar si el ID es distinto de NULL y si el odontologo existe
        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()) != null){
            response= ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        odontologoService.eliminar(id);

        response= ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){


        if (odontologoService.buscar(id)!=null){
            return ResponseEntity.ok(odontologoService.buscar(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
