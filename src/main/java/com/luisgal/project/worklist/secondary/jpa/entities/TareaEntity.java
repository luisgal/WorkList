package com.luisgal.project.worklist.secondary.jpa.entities;

import com.luisgal.project.worklist.core.enums.Estado;
import com.luisgal.project.worklist.core.enums.Prioridad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
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

  @Column(name = "fecha_creacion", insertable = false, updatable = false)
  private LocalDateTime fechaCreacion;

  @Column(name = "tiempo_estimado")
  private LocalTime tiempoEstimado = LocalTime.of(0,0);

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_actual")
  private Estado estadoActual = Estado.POR_HACER;

  @Column(name = "fecha_vencimiento")
  private LocalDateTime fechaVencimiento;

  @Enumerated(EnumType.STRING)
  @Column(name = "urgencia")
  private Prioridad prioridad;

  @OneToMany(mappedBy = "tarea")
  private List<ColaboradorEntity> colaboradores;
}
