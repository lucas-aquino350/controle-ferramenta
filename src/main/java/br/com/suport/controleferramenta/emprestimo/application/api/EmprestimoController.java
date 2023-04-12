package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.emprestimo.application.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<EmprestimoListResponse> getTodosEmprestimos() {
        log.info("[inicia] EmprestimoController - getTodosEmprestimos");
        List<EmprestimoListResponse> emprestimos = emprestimoService.buscaTodosEmprestimos();
        log.info("[finaliza] EmprestimoController - getTodosEmprestimos");
        return emprestimos;
    }

    @Override
    public EmprestimoDetalhadoResponse getEmprestimoAtravesId(UUID idEmprestimo) {
        log.info("[inicia] EmprestimoController - getEmprestimoAtravesId");
        EmprestimoDetalhadoResponse emprestimoDetalhado = emprestimoService.buscaEmprestimoPorId(idEmprestimo);
        log.info("[finaliza] EmprestimoController - getEmprestimoAtravesId");
        return emprestimoDetalhado;
    }

    @Override
    public void deletaEmprestimoAtravesId(UUID idEmprestimo) {
        log.info("[inicia] EmprestimoController - deletaEmprestimoAtravesId");
        emprestimoService.deletaEmprestimoPorId(idEmprestimo);
        log.info("[finaliza] EmprestimoController - deletaEmprestimoAtravesId");
    }

    @Override
    public void patchAlteraEmprestimo(UUID idEmprestimo, EmprestimoAlteracaoRequest emprestimoAlteracaoRequest) {
        log.info("[inicia] EmprestimoController - patchAlteraEmprestimo");
        emprestimoService.alteraEmprestimo(idEmprestimo, emprestimoAlteracaoRequest);
        log.info("[finaliza] EmprestimoController - patchAlteraEmprestimo");
    }
}