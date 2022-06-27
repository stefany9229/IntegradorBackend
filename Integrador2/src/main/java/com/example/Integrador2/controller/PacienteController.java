package com.example.Integrador2.controller;




import com.example.Integrador2.model.Paciente;
import com.example.Integrador2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente)) ;
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Paciente> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null){
            response= ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        pacienteService.eliminar(id);

        response= ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscar(id));
    }

}

