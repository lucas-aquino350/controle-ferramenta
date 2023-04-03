package br.com.suport.controleferramenta.ferramenta.application.service;

import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaDetalhadaResponse;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaListResponse;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaRequest;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaResponse;

import java.util.List;
import java.util.UUID;

public interface FerramentaService {
    FerramentaResponse criaFerramenta(FerramentaRequest ferramentaRequest);
    List<FerramentaListResponse> buscaTodasFerramentas();
    FerramentaDetalhadaResponse buscaFerramentaPorId(UUID idFerramenta);
    void deletaPorId(UUID idFerramenta);
}