package br.com.suport.controleferramenta.ferramenta.application.service;

import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaRequest;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaResponse;

public interface FerramentaService {
    FerramentaResponse criaFerramenta(FerramentaRequest ferramentaRequest);
}
