package com.duoc.transporte_rabbitmq.controller;

import com.duoc.transporte_rabbitmq.service.ProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TransporteController {

    @Autowired
    private ProductorService productorService;

    @PostMapping("/gps")
    public String enviarGps(@RequestBody Map<String, Object> datos) {
        productorService.enviarAColaGps(datos);
        return "Coordenadas enviadas a la cola GPS";
    }

    @PostMapping("/horario")
    public String enviarHorario(@RequestBody Map<String, Object> datos) {
        productorService.enviarAColaHorarios(datos);
        return "Horario enviado a la cola Horarios";
    }
}