package com.luisgal.project.worklist.core.business;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.secondary.TareaPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService{

  private final TareaPort tareaPort;
  @Override
  public String crearTarea(String usuarioId, TareaDom tareaDom) {
    return tareaPort.saveTarea(usuarioId, tareaDom);
  }

  @Override
  public TareaDom buscarTarea(String id) {
    return tareaPort.findById(id).orElse(new TareaDom());
  }

  @Override
  public List<UsuarioDom> buscarColaboradores(String id) {
    return tareaPort.findAllColaboradores(id);
  }
}
