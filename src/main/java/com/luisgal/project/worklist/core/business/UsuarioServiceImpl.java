package com.luisgal.project.worklist.core.business;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.secondary.UsuarioPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

  private final UsuarioPort usuarioPort;
  @Override
  public String crearUsuario(UsuarioDom usuarioDom) {
    return usuarioPort.saveUsuario(usuarioDom);
  }

  @Override
  public UsuarioDom buscarUsuario(String id) {
    return usuarioPort.findById(id).orElse(new UsuarioDom());
  }

  @Override
  public List<TareaDom> buscarTareas(String id) {
    return usuarioPort.findAllTareas(id);
  }
}
