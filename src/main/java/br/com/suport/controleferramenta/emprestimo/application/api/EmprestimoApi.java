package br.com.suport.controleferramenta.emprestimo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/emprestimo")
public interface EmprestimoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EmprestimoResponse postCliente(@Valid @RequestBody EmprestimoRequest emprestimoRequest);

}