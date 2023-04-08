package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.emprestimo.application.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EmprestimoController implements EmprestimoApi {

    private final EmprestimoService emprestimoService;

    @Override
    public EmprestimoResponse postCliente(EmprestimoRequest emprestimoRequest) {
        log.info("[inicia] EmprestimoController - postCliente");
        EmprestimoResponse emprestimoCriado = emprestimoService.criaEmprestimo(emprestimoRequest);
        log.info("[finaliza] EmprestimoController - postCliente");
        return emprestimoCriado;
    }
}