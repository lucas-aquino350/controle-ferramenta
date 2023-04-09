package br.com.suport.controleferramenta.emprestimo.infra;

import br.com.suport.controleferramenta.emprestimo.application.repository.EmprestimoRepository;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;


@Repository
@Log4j2
@RequiredArgsConstructor
public class EmprestimoInfraRepository implements EmprestimoRepository {

    private final EmprestimoMongoSpringData emprestimoMongoSpringData;

    @Override
    public Emprestimo salva(Emprestimo emprestimo) {
        log.info("[inicia] EmprestimoInfraRepository - salva");
        emprestimoMongoSpringData.save(emprestimo);
        log.info("[finaliza] EmprestimoInfraRepository - salva");
        return emprestimo;
    }
}