package com.luisgal.project.worklist.primary.http;

import com.luisgal.project.worklist.core.business.ColaboradorService;
import com.luisgal.project.worklist.core.mappers.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador")
@RequiredArgsConstructor
public class ColaboradorController {

  private final ColaboradorService colaboradorService;
  private final ColaboradorMapper colaboradorMapper;

  @PostMapping
  public CrearColaboradorResponse crearColaborador(@RequestBody CrearColaboradorRequest request){
    String id = colaboradorService.crearColaborador(colaboradorMapper.requestToDom(request));
    return new CrearColaboradorResponse(id);
  }

  @GetMapping("/{id}")
  public BuscarColaboradorResponse buscarColaborador(@PathVariable("id") String id){
    return colaboradorMapper.domToResponse(colaboradorService.buscarColaborador(id));
  }

  record CrearColaboradorResponse(String colaboradorId){}
  public record CrearColaboradorRequest(String usuarioId, String tareaId){}
  public record BuscarColaboradorResponse(String colaboradorId, String usuarioId, String tareaId, Boolean responsableDirecto){}
}
