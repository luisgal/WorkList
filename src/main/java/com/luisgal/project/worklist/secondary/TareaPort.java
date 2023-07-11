package com.luisgal.project.worklist.secondary;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import java.util.List;
import java.util.Optional;

public interface TareaPort {
  String saveTarea(String usuarioId, TareaDom tareaDom);
  Optional<TareaDom> findById(String id);
  List<UsuarioDom> findAllColaboradores(String id);
}
