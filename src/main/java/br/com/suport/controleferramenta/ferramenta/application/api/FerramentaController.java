package br.com.suport.controleferramenta.ferramenta.application.api;

import br.com.suport.controleferramenta.ferramenta.application.service.FerramentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FerramentaController implements FerramentaApi {

    private final FerramentaService ferramentaSerrvice;

    @Override
    public FerramentaResponse postFerramenta(FerramentaRequest ferramentaRequest) {
        log.info("[inicia] FerramentaController - postFerramenta");
        FerramentaResponse ferramentaCriada = ferramentaSerrvice.criaFerramenta(ferramentaRequest);
        log.info("[finaliza] FerramentaController - postFerramenta");
        return ferramentaCriada;
    }
}
