package br.com.suport.controleferramenta.emprestimo.application.service;

import br.com.suport.controleferramenta.emprestimo.application.api.*;

import java.util.List;
import java.util.UUID;

public interface EmprestimoService {
    EmprestimoResponse criaEmprestimo(EmprestimoRequest emprestimoRequest);
    List<EmprestimoListResponse> buscaTodosEmprestimos();
    EmprestimoDetalhadoResponse buscaEmprestimoPorId(UUID idEmprestimo);
    void deletaEmprestimoPorId(UUID idEmprestimo);
    void alteraEmprestimo(UUID idEmprestimo, EmprestimoAlteracaoRequest emprestimoAlteracaoRequest);
    void devolveEmprestimo(UUID idEmprestimo, EmprestimoDevolucaoRequest emprestimoAlteracaoRequest);
    List<EmprestimoListResponse> buscaEmprestimoPorFerramenta(UUID idFerramenta);
}