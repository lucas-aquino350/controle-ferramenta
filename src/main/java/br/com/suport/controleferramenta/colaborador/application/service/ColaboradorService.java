package br.com.suport.controleferramenta.colaborador.application.service;

import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorRequest;
import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorResponse;

public interface ColaboradorService {
    ColaboradorResponse criaColaborador(ColaboradorRequest colaboradorRequest);
}
