package com.luisgal.project.worklist.core.mappers;

import com.luisgal.project.worklist.core.domain.ColaboradorDom;
import com.luisgal.project.worklist.primary.http.ColaboradorController.BuscarColaboradorResponse;
import com.luisgal.project.worklist.primary.http.ColaboradorController.CrearColaboradorRequest;
import com.luisgal.project.worklist.secondary.jpa.entities.ColaboradorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ColaboradorMapper {
  @Mapping(target = "usuarioId", source = "usuario.usuarioId")
  @Mapping(target = "tareaId", source = "tarea.tareaId")
  ColaboradorDom entityToDom(ColaboradorEntity colaboradorEntity);
  @InheritInverseConfiguration
  ColaboradorEntity domToEntity(ColaboradorDom colaboradorDom);
  ColaboradorDom requestToDom(CrearColaboradorRequest request);
  BuscarColaboradorResponse domToResponse(ColaboradorDom colaboradorDom);
}
