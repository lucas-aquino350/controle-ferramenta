package br.com.suport.controleferramenta.emprestimo.application.service;

import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoListResponse;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoRequest;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoResponse;

import java.util.List;

public interface EmprestimoService {
    EmprestimoResponse criaEmprestimo(EmprestimoRequest emprestimoRequest);
    List<EmprestimoListResponse> buscaTodosEmprestimos();
}