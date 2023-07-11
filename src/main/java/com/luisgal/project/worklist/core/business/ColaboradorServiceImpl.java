package com.luisgal.project.worklist.core.business;

import com.luisgal.project.worklist.core.domain.ColaboradorDom;
import com.luisgal.project.worklist.secondary.ColaboradorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ColaboradorServiceImpl implements ColaboradorService{

  private final ColaboradorPort colaboradorPort;
  @Override
  public String crearColaborador(ColaboradorDom colaboradorDom) {
    return colaboradorPort.saveColaborador(colaboradorDom);
  }

  @Override
  public ColaboradorDom buscarColaborador(String id) {
    return colaboradorPort.findById(id).orElse(new ColaboradorDom());
  }
}
