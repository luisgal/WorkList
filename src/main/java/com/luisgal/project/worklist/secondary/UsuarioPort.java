package com.luisgal.project.worklist.secondary;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import java.util.List;
import java.util.Optional;

public interface UsuarioPort {
  String saveUsuario(UsuarioDom usuarioDom);
  Optional<UsuarioDom> findById(String id);
  List<TareaDom> findAllTareas(String id);
}
