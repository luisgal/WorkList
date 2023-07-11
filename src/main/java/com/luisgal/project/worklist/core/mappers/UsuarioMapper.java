package com.luisgal.project.worklist.core.mappers;

import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.primary.http.UsuarioController.BuscarUsuarioResponse;
import com.luisgal.project.worklist.primary.http.UsuarioController.CrearUsuarioRequest;
import com.luisgal.project.worklist.secondary.jpa.entities.TareaEntity;
import com.luisgal.project.worklist.secondary.jpa.entities.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
  UsuarioDom entityToDom(UsuarioEntity usuarioEntity);
  UsuarioEntity domToEntity(UsuarioDom usuarioDom);
  UsuarioDom requestToDom(CrearUsuarioRequest request);
  BuscarUsuarioResponse domToResponse(UsuarioDom usuarioDom);
  TareaDom tareaEntityToDom(TareaEntity tareaEntity);
}
