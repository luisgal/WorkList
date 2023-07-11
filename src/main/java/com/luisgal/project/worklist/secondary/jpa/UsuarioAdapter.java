package com.luisgal.project.worklist.secondary.jpa;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.core.mappers.UsuarioMapper;
import com.luisgal.project.worklist.secondary.UsuarioPort;
import com.luisgal.project.worklist.secondary.jpa.entities.TareaEntity;
import com.luisgal.project.worklist.secondary.jpa.entities.UsuarioEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements UsuarioPort {

  private final UsuarioRepository usuarioRepository;
  private final UsuarioMapper usuarioMapper;

  @Override
  public String saveUsuario(UsuarioDom usuarioDom) {
    return usuarioRepository.save(usuarioMapper.domToEntity(usuarioDom)).getUsuarioId();
  }

  @Override
  public Optional<UsuarioDom> findById(String id) {
    return usuarioRepository
        .findById(id)
        .map(usuarioMapper::entityToDom);
  }

  @Override
  public List<TareaDom> findAllTareas(String id) {
    /*
    return usuarioRepository
        .findById(id)
        .orElse(new UsuarioEntity())
        .getColaboradores()
        .stream()
        .map(ColaboradorEntity::getTarea)
        .map(usuarioMapper::tareaEntityToDom)
        .toList();
     */
    return usuarioRepository
        .findTareasById(id)
        .stream()
        .map(usuarioMapper::tareaEntityToDom)
        .toList();
  }

  public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    @Query("select t from UsuarioEntity u join ColaboradorEntity c on u.usuarioId = c.usuario.usuarioId join TareaEntity t on c.tarea.tareaId = t.tareaId where u.usuarioId = :id")
    List<TareaEntity> findTareasById(@Param("id") String id);
  }
}
