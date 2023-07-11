package com.luisgal.project.worklist.secondary.jpa;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.core.mappers.TareaMapper;
import com.luisgal.project.worklist.secondary.TareaPort;
import com.luisgal.project.worklist.secondary.jpa.ColaboradorAdapter.ColaboradorRepository;
import com.luisgal.project.worklist.secondary.jpa.entities.ColaboradorEntity;
import com.luisgal.project.worklist.secondary.jpa.entities.TareaEntity;
import com.luisgal.project.worklist.secondary.jpa.entities.UsuarioEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TareaAdapter implements TareaPort {

  private final TareaMapper tareaMapper;
  private final TareaRepository tareaRepository;
  private final ColaboradorRepository colaboradorRepository;

  @Transactional
  public String saveTarea(String usuarioId,TareaDom tareaDom){
    TareaEntity tareaEntity = tareaRepository.save(tareaMapper.domToEntity(tareaDom));
    ColaboradorEntity colaboradorEntity = new ColaboradorEntity();
    colaboradorEntity.setTarea(tareaEntity);
    colaboradorEntity.setUsuario(new UsuarioEntity(usuarioId));
    colaboradorRepository.save(colaboradorEntity);
    return tareaEntity.getTareaId();
  }

  @Override
  public Optional<TareaDom> findById(String id) {
    return tareaRepository
        .findById(id)
        .map(tareaMapper::entityToDom);
  }

  @Override
  public List<UsuarioDom> findAllColaboradores(String id) {
    return tareaRepository
        .findColaboradoresById(id)
        .stream()
        .map(tareaMapper::usuarioEntityToDom)
        .toList();
  }

  public interface TareaRepository extends JpaRepository<TareaEntity, String>{

    @Query("select u from TareaEntity t join ColaboradorEntity c on t.tareaId = c.tarea.tareaId join UsuarioEntity u on c.usuario.usuarioId = u.usuarioId where t.tareaId = :id")
    List<UsuarioEntity> findColaboradoresById(@Param("id") String id);
  }
}
