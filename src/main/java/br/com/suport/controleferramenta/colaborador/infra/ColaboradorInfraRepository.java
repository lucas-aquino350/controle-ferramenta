package br.com.suport.controleferramenta.colaborador.infra;

import br.com.suport.controleferramenta.colaborador.application.repository.ColaboradorRepository;
import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ColaboradorInfraRepository implements ColaboradorRepository {
    private final ColaboradorMongoSpringRepository colaboradorMongoSpringRepository;

    @Override
    public Colaborador salva(Colaborador colaborador) {
        log.info("[inicia] ColaboradorInfraRepository -  salva");
        colaboradorMongoSpringRepository.save(colaborador);
        log.info("[finaliza] ColaboradorInfraRepository -  salva");
        return colaborador;
    }
}