package br.com.suport.controleferramenta.ferramenta.infra;

import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface FerramentaMongoSpringRepository extends MongoRepository<Ferramenta, UUID> {
    Optional<Ferramenta> findById(UUID idFerramenta);
}
