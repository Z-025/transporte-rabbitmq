package com.duoc.transporte_rabbitmq.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "VEHICULO_LOGS")
@Data
public class VehiculoLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 4000) 
    private String mensaje;
    
    private LocalDateTime fecha = LocalDateTime.now();
}