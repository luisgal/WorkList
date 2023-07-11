package com.luisgal.project.worklist.core.business;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import java.util.List;

public interface UsuarioService {
  String crearUsuario(UsuarioDom usuarioDom);
  UsuarioDom buscarUsuario(String id);
  List<TareaDom> buscarTareas(String id);
}
