package br.com.suport.controleferramenta.ferramenta.application.service;

import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaRequest;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaResponse;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FerramentaApplicationService implements FerramentaService {

    @Override
    public FerramentaResponse criaFerramenta(FerramentaRequest ferramentaRequest) {
        log.info("[inicia] FerramentaApplicationService - criaFerramenta");
        log.info("[finaliza] FerramentaApplicationService - criaFerramenta");
        return null;
    }
}
