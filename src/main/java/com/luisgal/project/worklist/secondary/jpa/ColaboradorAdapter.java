package com.luisgal.project.worklist.secondary.jpa;

import com.luisgal.project.worklist.core.domain.ColaboradorDom;
import com.luisgal.project.worklist.core.mappers.ColaboradorMapper;
import com.luisgal.project.worklist.secondary.ColaboradorPort;
import com.luisgal.project.worklist.secondary.jpa.entities.ColaboradorEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ColaboradorAdapter implements ColaboradorPort {

  private final ColaboradorRepository colaboradorRepository;
  private final ColaboradorMapper colaboradorMapper;
  @Override
  public String saveColaborador(ColaboradorDom colaboradorDom) {
    return colaboradorRepository.save(colaboradorMapper.domToEntity(colaboradorDom)).getColaboradorId();
  }

  @Override
  public Optional<ColaboradorDom> findById(String id) {
    return colaboradorRepository
        .findById(id)
        .map(colaboradorMapper::entityToDom);
  }

  public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, String>{

  }
}
