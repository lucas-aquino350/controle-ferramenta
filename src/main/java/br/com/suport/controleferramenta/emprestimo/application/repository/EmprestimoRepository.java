package br.com.suport.controleferramenta.emprestimo.application.repository;

import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmprestimoRepository {
    Emprestimo salva(Emprestimo emprestimo);
    List<Emprestimo> buscaTodosEmprestimos();
}