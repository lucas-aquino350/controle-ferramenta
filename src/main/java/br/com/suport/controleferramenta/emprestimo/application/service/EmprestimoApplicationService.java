package br.com.suport.controleferramenta.emprestimo.application.service;

import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoRequest;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmprestimoApplicationService implements EmprestimoService {
    @Override
    public EmprestimoResponse criaEmprestimo(EmprestimoRequest emprestimoRequest) {
        log.info("[inicia] EmprestimoApplicationService - criaEmprestimo");
        log.info("[finaliza] EmprestimoApplicationService - criaEmprestimo");
        return null;
    }
}
