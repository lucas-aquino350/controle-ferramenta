package br.com.suport.controleferramenta.emprestimo.infra;

import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface EmprestimoMongoSpringData extends MongoRepository<Emprestimo, UUID> {
    List<Emprestimo> findAllByIdFerramenta(UUID idFerramenta);
    List<Emprestimo> findAllByIdColaborador(UUID idColaborador);
}