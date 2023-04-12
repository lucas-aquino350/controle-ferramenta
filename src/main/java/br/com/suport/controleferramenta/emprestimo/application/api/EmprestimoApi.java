package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/emprestimo")
public interface EmprestimoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EmprestimoResponse postCliente(@Valid @RequestBody EmprestimoRequest emprestimoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EmprestimoListResponse> getTodosEmprestimos();

    @GetMapping("/{idEmprestimo}")
    @ResponseStatus(code = HttpStatus.OK)
    EmprestimoDetalhadoResponse getEmprestimoAtravesId (@PathVariable UUID idEmprestimo);

    @DeleteMapping("/{idEmprestimo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaEmprestimoAtravesId(@PathVariable UUID idEmprestimo);

    @PatchMapping("/{idEmprestimo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraEmprestimo(@PathVariable UUID idEmprestimo, @Valid @RequestBody EmprestimoAlteracaoRequest emprestimoAlteracaoRequest);

}