package com.luisgal.project.worklist.secondary.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "usuario", schema = "public", catalog = "worklist")
@Getter
@Setter
@NoArgsConstructor
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

  @Column(name = "fecha_registro", insertable = false, updatable = false)
  private LocalDate fechaRegistro;

  @OneToMany(mappedBy = "usuario")
  private List<ColaboradorEntity> colaboradores;

  public UsuarioEntity(String usuarioId){
    this.usuarioId = usuarioId;
  }
}
