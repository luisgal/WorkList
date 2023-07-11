package com.luisgal.project.worklist.core.domain;

import lombok.Data;

@Data
public class ColaboradorDom {
  private String colaboradorId;
  private String usuarioId;
  private String tareaId;
  private Boolean responsableDirecto;
}
