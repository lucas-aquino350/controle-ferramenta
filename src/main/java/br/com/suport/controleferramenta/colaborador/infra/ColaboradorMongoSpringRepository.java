package br.com.suport.controleferramenta.colaborador.infra;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ColaboradorMongoSpringRepository extends MongoRepository<Colaborador, UUID> {
}
