package com.duoc.transporte_rabbitmq.service;  // <--- OJO AQUI: transporte_rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductorService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Inicializamos el ObjectMapper aquí mismo para evitar errores de inyección
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void enviarAColaGps(Object mensaje) {
        try {
            String json = objectMapper.writeValueAsString(mensaje);
            rabbitTemplate.convertAndSend("queue_gps", json);
            System.out.println("Enviado a GPS: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarAColaHorarios(Object mensaje) {
        try {
            String json = objectMapper.writeValueAsString(mensaje);
            rabbitTemplate.convertAndSend("queue_horarios", json);
            System.out.println("Enviado a Horarios: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}