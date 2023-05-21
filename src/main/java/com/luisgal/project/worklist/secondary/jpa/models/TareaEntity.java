package com.luisgal.project.worklist.secondary.jpa.models;

import com.luisgal.project.worklist.core.enums.Estado;
import com.luisgal.project.worklist.core.enums.Prioridad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarea", schema = "public", catalog = "worklist")
@Getter
@Setter
public class TareaEntity {

  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  @Column(name = "tarea_id")
  private String tareaId;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "fecha_creacion")
  private Date fechaCreacion;

  @Column(name = "urgencia")
  private Prioridad prioridad;

  @Column(name = "tiempo_estimado")
  private Time tiempoEstimado;

  @Column(name = "estado_actual")
  private Estado estadoActual;

  @Column(name = "fecha_vencimiento")
  private Timestamp fechaVencimiento;
}
