package br.com.suport.controleferramenta.emprestimo.application.service;

import br.com.suport.controleferramenta.colaborador.application.repository.ColaboradorRepository;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoListResponse;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoRequest;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoResponse;
import br.com.suport.controleferramenta.emprestimo.application.repository.EmprestimoRepository;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmprestimoApplicationService implements EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    @Override
    public EmprestimoResponse criaEmprestimo(EmprestimoRequest emprestimoRequest) {
        log.info("[inicia] EmprestimoApplicationService - criaEmprestimo");
        Emprestimo emprestimo = emprestimoRepository.salva(new Emprestimo(emprestimoRequest));
        log.info("[finaliza] EmprestimoApplicationService - criaEmprestimo");
        return EmprestimoResponse
                .builder()
                .idEmprestimo(emprestimo.getIdEmprestimo()).build();
    }

    @Override
    public List<EmprestimoListResponse> buscaTodosEmprestimos() {
        log.info("[inicia] EmprestimoApplicationService - buscaTodosEmprestimos");
        List<Emprestimo> emprestimos = emprestimoRepository.buscaTodosEmprestimos();
        log.info("[finaliza] EmprestimoApplicationService - buscaTodosEmprestimos");
        return EmprestimoListResponse.converte(emprestimos);
    }
}
