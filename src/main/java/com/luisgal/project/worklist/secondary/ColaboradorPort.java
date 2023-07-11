package com.luisgal.project.worklist.secondary;

import com.luisgal.project.worklist.core.domain.ColaboradorDom;
import java.util.Optional;

public interface ColaboradorPort {
  String saveColaborador(ColaboradorDom colaboradorDom);
  Optional<ColaboradorDom> findById(String id);
}
