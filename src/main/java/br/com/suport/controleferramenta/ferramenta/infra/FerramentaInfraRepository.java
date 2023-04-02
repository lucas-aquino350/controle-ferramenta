package br.com.suport.controleferramenta.ferramenta.infra;

import br.com.suport.controleferramenta.ferramenta.application.repository.FerramentaRepository;
import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FerramentaInfraRepository implements FerramentaRepository {
    private final FerramentaMongoSpringRepository ferramentaMongoSpringRepository;

    @Override
    public Ferramenta salva(Ferramenta ferramenta) {
        log.info("[inicia] FerramentaInfraRepository - salva");
        ferramentaMongoSpringRepository.save(ferramenta);
        log.info("[finaliza] FerramentaInfraRepository - salva");
        return ferramenta;
    }
}
