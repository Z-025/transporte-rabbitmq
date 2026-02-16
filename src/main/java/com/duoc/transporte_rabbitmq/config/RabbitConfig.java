package com.duoc.transporte_rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    // Cola 1: Para guardar en Base de Datos
    @Bean
    public Queue colaGps() {
        return new Queue("queue_gps", true);
    }

    // Cola 2: Para generar Archivo JSON
    @Bean
    public Queue colaHorarios() {
        return new Queue("queue_horarios", true);
    }
}