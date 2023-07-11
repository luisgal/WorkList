package com.luisgal.project.worklist.secondary.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  @Column(name = "responsable_directo")
  private Boolean responsableDirecto = false;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private UsuarioEntity usuario;

  @ManyToOne
  @JoinColumn(name = "tarea_id")
  private TareaEntity tarea;
}
