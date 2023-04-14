package br.com.suport.controleferramenta.emprestimo.infra;

import br.com.suport.controleferramenta.emprestimo.application.repository.EmprestimoRepository;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import br.com.suport.controleferramenta.ferramenta.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


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

    @Override
    public List<Emprestimo> buscaTodosEmprestimos() {
        log.info("[inicia] EmprestimoInfraRepository - buscaTodosEmprestimos");
        List<Emprestimo> todosEmprestimos = emprestimoMongoSpringData.findAll();
        log.info("[finaliza] EmprestimoInfraRepository - buscaTodosEmprestimos");
        return todosEmprestimos;
    }

    @Override
    public Emprestimo buscaEmprestimoPorId(UUID idEmprestimo) {
        log.info("[inicia] EmprestimoInfraRepository - buscaEmprestimoPorId");
        Emprestimo emprestimo = emprestimoMongoSpringData.findById(idEmprestimo)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"Emprestimo não encontrado!"));
        log.info("[finaliza] EmprestimoInfraRepository - buscaEmprestimoPorId");
        return emprestimo;
    }

    @Override
    public void deleta(Emprestimo emprestimo) {
        log.info("[inicia] EmprestimoInfraRepository - deleta");
        emprestimoMongoSpringData.delete(emprestimo);
        log.info("[finaliza] EmprestimoInfraRepository - deleta");
    }

    @Override
    public List<Emprestimo> buscaEmprestimoPorFerramenta(UUID idFerramenta) {
        log.info("[inicia] EmprestimoInfraRepository - buscaEmprestimoPorFerramenta");
        List<Emprestimo> listaDeEmprestimos = emprestimoMongoSpringData.findAllByIdFerramenta(idFerramenta);
        log.info("[finaliza] EmprestimoInfraRepository - buscaEmprestimoPorFerramenta");
        return listaDeEmprestimos;
    }

    @Override
    public List<Emprestimo> buscaEmprestimoPorColaborador(UUID idColaborador) {
        log.info("[inicia] EmprestimoInfraRepository - buscaEmprestimoPorColaborador");
        List<Emprestimo> listaDeEmprestimos = emprestimoMongoSpringData.findAllByIdColaborador(idColaborador);
        log.info("[inicia] EmprestimoInfraRepository - buscaEmprestimoPorColaborador");
        return listaDeEmprestimos;
    }
}