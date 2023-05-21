package com.luisgal.project.worklist.secondary.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuario", schema = "public", catalog = "worklist")
@Getter
@Setter
public class UsuarioEntity {

  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  @Column(name = "usuario_id")
  private String usuarioId;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @Column(name = "cargo")
  private String cargo;

  @Column(name = "fecha_registro")
  private Date fechaRegistro;
}
