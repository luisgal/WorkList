package com.luisgal.project.worklist.core.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

@Data
public class TareaDom {
  private String tareaId;
  private String nombre;
  private String descripcion;
  private LocalDateTime fechaCreacion;
  private String prioridad;
  private LocalTime tiempoEstimado;
  private String estadoActual;
  private LocalDateTime fechaVencimiento;
}