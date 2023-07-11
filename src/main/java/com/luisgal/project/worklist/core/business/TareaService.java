package com.luisgal.project.worklist.core.business;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import java.util.List;

public interface TareaService {
  String crearTarea(String usuarioId, TareaDom tareaDom);
  TareaDom buscarTarea(String id);
  List<UsuarioDom> buscarColaboradores(String id);
}
