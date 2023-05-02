package br.com.suport.controleferramenta.ferramenta.infra;

import br.com.suport.controleferramenta.ferramenta.application.repository.FerramentaRepository;
import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;
import br.com.suport.controleferramenta.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FerramentaInfraRepository implements FerramentaRepository {
    private final FerramentaMongoSpringRepository ferramentaMongoSpringRepository;

    @Override
    public Ferramenta salva(Ferramenta ferramenta) {
        log.info("[inicia] FerramentaInfraRepository - salva");
        try {
            ferramentaMongoSpringRepository.save(ferramenta);
        } catch(DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados",e);
        }
        log.info("[finaliza] FerramentaInfraRepository - salva");
        return ferramenta;
    }

    @Override
    public List<Ferramenta> buscaTodasFerramentas() {
        log.info("[inicia] FerramentaInfraRepository - buscaTodasFerramentas");
        List<Ferramenta> todasFerramentas = ferramentaMongoSpringRepository.findAll();
        log.info("[finaliza] FerramentaInfraRepository - buscaTodasFerramentas");
        return todasFerramentas;
    }

    @Override
    public Ferramenta buscaFerramentaPorId(UUID idFerramenta) {
        log.info("[inicia] FerramentaInfraRepository - buscaFerramentaPorId");
        Ferramenta ferramenta = ferramentaMongoSpringRepository.findById(idFerramenta)
                        .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Ferramenta não encontrada!"));
        log.info("[finaliza] FerramentaInfraRepository - buscaFerramentaPorId");
        return ferramenta;
    }

    @Override
    public void deleta(Ferramenta ferramenta) {
        log.info("[inicia] FerramentaInfraRepository - deleta");
        ferramentaMongoSpringRepository.delete(ferramenta);
        log.info("[finaliza] FerramentaInfraRepository - deleta");
    }
}
