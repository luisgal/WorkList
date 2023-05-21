package com.luisgal.project.worklist.secondary.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "colaborador", schema = "public", catalog = "worklist")
@Getter
@Setter
public class ColaboradorEntity {

  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  @Column(name = "colaborador_id")
  private String colaboradorId;

  @Column(name = "usuario_id")
  private String usuarioId;

  @Column(name = "tarea_id")
  private String tareaId;

  @Column(name = "responsable_directo")
  private Boolean responsableDirecto;
}
