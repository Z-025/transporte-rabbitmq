package com.duoc.transporte_rabbitmq.consumer;

import com.duoc.transporte_rabbitmq.model.VehiculoLog;
import com.duoc.transporte_rabbitmq.repository.LogRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.PrintWriter;

@Component
public class TransporteConsumer {

    @Autowired
    private LogRepository logRepository;

    // CONSUMIDOR 1: Guarda en Oracle
    @RabbitListener(queues = "queue_gps")
    public void procesarGps(String mensaje) {
        System.out.println("--> [Oracle] Guardando: " + mensaje);
        VehiculoLog log = new VehiculoLog();
        log.setMensaje(mensaje);
        logRepository.save(log);
    }

    // CONSUMIDOR 2: Crea archivo JSON
    @RabbitListener(queues = "queue_horarios")
    public void procesarHorario(String mensaje) {
        System.out.println("--> [Archivo] Escribiendo: " + mensaje);
        // Esto creará el archivo en la raíz de tu proyecto
        try (PrintWriter out = new PrintWriter(new FileWriter("horarios_log.json", true))) {
            out.println(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}