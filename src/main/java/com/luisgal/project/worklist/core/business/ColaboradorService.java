package com.luisgal.project.worklist.core.business;

import com.luisgal.project.worklist.core.domain.ColaboradorDom;

public interface ColaboradorService {
  String crearColaborador(ColaboradorDom colaboradorDom);
  ColaboradorDom buscarColaborador(String id);
}
