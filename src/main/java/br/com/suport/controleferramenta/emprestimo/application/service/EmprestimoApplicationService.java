package br.com.suport.controleferramenta.emprestimo.application.service;

import br.com.suport.controleferramenta.colaborador.application.repository.ColaboradorRepository;
import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import br.com.suport.controleferramenta.emprestimo.application.api.*;
import br.com.suport.controleferramenta.emprestimo.application.repository.EmprestimoRepository;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmprestimoApplicationService implements EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final ColaboradorRepository colaboradorRepository;

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
        return emprestimos
                .stream().map(e -> new EmprestimoListResponse(e, colaboradorRepository.buscaColaboradorPorId(e.getIdColaborador())))
                .collect(Collectors.toList());
    }

    @Override
    public EmprestimoDetalhadoResponse buscaEmprestimoPorId(UUID idEmprestimo) {
        log.info("[inicia] EmprestimoApplicationService - buscaEmprestimoPorId");
        Emprestimo emprestimo = emprestimoRepository.buscaEmprestimoPorId(idEmprestimo);
        Colaborador colaborador = colaboradorRepository.buscaColaboradorPorId(emprestimo.getIdColaborador());
        log.info("[finaliza] EmprestimoApplicationService - buscaEmprestimoPorId");
        return new EmprestimoDetalhadoResponse(emprestimo, colaborador);
    }

    @Override
    public void deletaEmprestimoPorId(UUID idEmprestimo) {
        log.info("[inicia] EmprestimoApplicationService - deletaEmprestimoPorId");
        Emprestimo emprestimo = emprestimoRepository.buscaEmprestimoPorId(idEmprestimo);
        emprestimoRepository.deleta(emprestimo);
        log.info("[finaliza] EmprestimoApplicationService - deletaEmprestimoPorId");
    }

    @Override
    public void alteraEmprestimo(UUID idEmprestimo, EmprestimoAlteracaoRequest emprestimoAlteracaoRequest) {
        log.info("[inicia] EmprestimoApplicationService - alteraEmprestimo");
        Emprestimo emprestimo = emprestimoRepository.buscaEmprestimoPorId(idEmprestimo);
        emprestimo.altera(emprestimoAlteracaoRequest);
        emprestimoRepository.salva(emprestimo);
        log.info("[finaliza] EmprestimoApplicationService - alteraEmprestimo");
    }
}