package com.duoc.transporte_rabbitmq.repository;

import com.duoc.transporte_rabbitmq.model.VehiculoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<VehiculoLog, Long> {
}