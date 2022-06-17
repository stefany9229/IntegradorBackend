package com.example.Integrador2.controller;


import com.example.Integrador2.dao.impl.OdontologoDaoH2;
import com.example.Integrador2.model.Odontologo;
import com.example.Integrador2.service.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    private OdontologoService OdontologoService = new OdontologoService(new OdontologoDaoH2());


    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(OdontologoService.buscarTodos());
    }
}
