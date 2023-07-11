package com.luisgal.project.worklist.primary.http;

import com.luisgal.project.worklist.core.business.TareaService;
import com.luisgal.project.worklist.core.domain.UsuarioDom;
import com.luisgal.project.worklist.core.mappers.TareaMapper;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

  private final TareaService tareaService;
  private final TareaMapper tareaMapper;

  @PostMapping
  public CrearTareaResponse crearTarea(@RequestBody CrearTareaRequest request){
    String id = tareaService.crearTarea(request.usuarioId, tareaMapper.requestToDom(request));
    return new CrearTareaResponse(id);
  }

  @GetMapping("/{id}")
  public BuscarTareaResponse buscarTarea(@PathVariable("id") String id){
    return tareaMapper.domToResponse(tareaService.buscarTarea(id));
  }

  @GetMapping("/colaboradores/{id}")
  public BuscarColaboradoresResponse buscarColaboradores(@PathVariable("id") String id){
    return new BuscarColaboradoresResponse(id, tareaService.buscarColaboradores(id));
  }

  public record CrearTareaRequest(String usuarioId, String nombre, String descripcion,
                                  String prioridad, LocalTime tiempoEstimado,
                                  String estadoActual, LocalDateTime fechaVencimiento){}

  record CrearTareaResponse(String tareaId){}

  public record BuscarTareaResponse(String tareaId, String nombre, String descripcion,
                                    LocalDateTime fechaCreacion, String prioridad,
                                    LocalTime tiempoEstimado, String estadoActual,
                                    LocalDateTime fechaVencimiento){}

  record BuscarColaboradoresResponse(String tareaId, List<UsuarioDom> colaboradores){}
}
