package com.example.Integrador2.controller;

import com.example.Integrador2.repository.impl.TurnoDao;
import com.example.Integrador2.service.TurnoService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService= new TurnoService(new TurnoDao());


}
