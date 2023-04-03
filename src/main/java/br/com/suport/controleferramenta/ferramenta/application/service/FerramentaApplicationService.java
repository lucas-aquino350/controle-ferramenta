package br.com.suport.controleferramenta.ferramenta.application.service;

import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaDetalhadaResponse;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaListResponse;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaRequest;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaResponse;
import br.com.suport.controleferramenta.ferramenta.application.repository.FerramentaRepository;
import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class FerramentaApplicationService implements FerramentaService {

    private final FerramentaRepository ferramentaRepository;

    @Override
    public FerramentaResponse criaFerramenta(FerramentaRequest ferramentaRequest) {
        log.info("[inicia] FerramentaApplicationService - criaFerramenta");
        Ferramenta ferramenta = ferramentaRepository.salva(new Ferramenta(ferramentaRequest));
        log.info("[finaliza] FerramentaApplicationService - criaFerramenta");
        return FerramentaResponse.builder()
                .idFerramenta(ferramenta.getIdFerramenta()).build();
    }

    @Override
    public List<FerramentaListResponse> buscaTodasFerramentas() {
        log.info("[inicia] FerramentaApplicationService - buscaTodasFerramentas");
        List<Ferramenta> ferramentas = ferramentaRepository.buscaTodasFerramentas();
        log.info("[finaliza] FerramentaApplicationService - buscaTodasFerramentas");
        return FerramentaListResponse.converte(ferramentas);
    }

    @Override
    public FerramentaDetalhadaResponse buscaFerramentaPorId(UUID idFerramenta) {
        log.info("[inicia] FerramentaApplicationService - buscaFerramentaPorId");
        Ferramenta ferramenta = ferramentaRepository.buscaFerramentaPorId(idFerramenta);
        log.info("[finaliza] FerramentaApplicationService - buscaFerramentaPorId");
        return new FerramentaDetalhadaResponse(ferramenta);
    }

    @Override
    public void deletaPorId(UUID idFerramenta) {
        log.info("[inicia] FerramentaApplicationService - deletaPorId");
        Ferramenta ferramenta = ferramentaRepository.buscaFerramentaPorId(idFerramenta);
        ferramentaRepository.deleta(ferramenta);
        log.info("[finaliza] FerramentaApplicationService - deletaPorId");
    }
}
