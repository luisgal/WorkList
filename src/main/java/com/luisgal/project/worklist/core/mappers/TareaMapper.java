package com.luisgal.project.worklist.core.mappers;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.primary.http.TareaController.BuscarTareaResponse;
import com.luisgal.project.worklist.primary.http.TareaController.CrearTareaRequest;
import com.luisgal.project.worklist.secondary.jpa.entities.TareaEntity;
import com.luisgal.project.worklist.secondary.jpa.entities.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TareaMapper {
  TareaDom entityToDom(TareaEntity tareaEntity);
  TareaEntity domToEntity(TareaDom tareaDom);
  TareaDom requestToDom(CrearTareaRequest request);
  BuscarTareaResponse domToResponse(TareaDom tareaDom);
  UsuarioDom usuarioEntityToDom(UsuarioEntity usuarioEntity);
}
