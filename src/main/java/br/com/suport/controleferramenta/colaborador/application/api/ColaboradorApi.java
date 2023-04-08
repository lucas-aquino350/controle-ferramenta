package br.com.suport.controleferramenta.colaborador.application.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/colaborador")
public interface ColaboradorApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ColaboradorResponse postColaborador (@Valid @RequestBody ColaboradorRequest colaboradorRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ColaboradorListResponse> getTodosColaboradores();
}