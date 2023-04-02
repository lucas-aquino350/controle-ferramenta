package br.com.suport.controleferramenta.ferramenta.application.api;

import br.com.suport.controleferramenta.ferramenta.application.service.FerramentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FerramentaController implements FerramentaApi {

    private final FerramentaService ferramentaService;

    @Override
    public FerramentaResponse postFerramenta(FerramentaRequest ferramentaRequest) {
        log.info("[inicia] FerramentaController - postFerramenta");
        FerramentaResponse ferramentaCriada = ferramentaService.criaFerramenta(ferramentaRequest);
        log.info("[finaliza] FerramentaController - postFerramenta");
        return ferramentaCriada;
    }

    @Override
    public List<FerramentaListResponse> getTodasFerramentas() {
        log.info("[inicia] FerramentaController - getTodasFerramentas");
        List<FerramentaListResponse> ferramentas = ferramentaService.buscaTodasFerramentas();
        log.info("[finaliza] FerramentaController - getTodasFerramentas");
        return ferramentas;
    }

    @Override
    public FerramentaDetalhadaResponse getFerramentaAtravesId(UUID idFerramenta) {
        log.info("[inicia] FerramentaController - getFerramentaAtravesId");
        log.info("[idFerramenta] {}", idFerramenta);
        FerramentaDetalhadaResponse ferramentaDetalhada = ferramentaService.buscaFerramentaPorId(idFerramenta);
        log.info("[finaliza] FerramentaController - getFerramentaAtravesId");
        return ferramentaDetalhada;
    }
}
