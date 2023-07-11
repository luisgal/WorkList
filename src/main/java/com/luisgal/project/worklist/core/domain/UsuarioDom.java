package com.luisgal.project.worklist.core.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UsuarioDom {
  private String usuarioId;
  private String nombre;
  private String apellido;
  private String cargo;
  private LocalDate fechaRegistro;
}
