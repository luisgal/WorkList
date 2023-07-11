package com.luisgal.project.worklist.primary.http;

import com.luisgal.project.worklist.core.business.UsuarioService;
import com.luisgal.project.worklist.core.domain.TareaDom;
import com.luisgal.project.worklist.core.mappers.UsuarioMapper;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService usuarioService;
  private final UsuarioMapper usuarioMapper;

  @PostMapping
  public CrearUsuarioResponse crearUsuario(@RequestBody CrearUsuarioRequest request){
    String id = usuarioService.crearUsuario(usuarioMapper.requestToDom(request));
    return new CrearUsuarioResponse(id);
  }

  @GetMapping("/{id}")
  public BuscarUsuarioResponse buscarUsuario(@PathVariable("id") String id){
    return usuarioMapper.domToResponse(usuarioService.buscarUsuario(id));
  }

  @GetMapping("/tareas/{id}")
  public BuscarTareasResponse buscarTareas(@PathVariable("id") String id){
    return new BuscarTareasResponse(id, usuarioService.buscarTareas(id));
  }

  public record CrearUsuarioRequest(String nombre, String apellido, String cargo){}
  record CrearUsuarioResponse(String usuarioId){}
  public record BuscarUsuarioResponse(String usuarioId, String nombre, String apellido, String cargo, LocalDate fechaRegistro){}
  record BuscarTareasResponse(String usuarioId, List<TareaDom> tareas){}
}
