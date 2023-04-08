package br.com.suport.controleferramenta.emprestimo.application.service;

import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoRequest;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoResponse;

public interface EmprestimoService {
    EmprestimoResponse criaEmprestimo(EmprestimoRequest emprestimoRequest);
}
