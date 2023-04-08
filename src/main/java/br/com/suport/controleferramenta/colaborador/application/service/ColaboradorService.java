package br.com.suport.controleferramenta.colaborador.application.service;

import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorListResponse;
import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorRequest;
import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorResponse;

import java.util.List;

public interface ColaboradorService {
    ColaboradorResponse criaColaborador(ColaboradorRequest colaboradorRequest);
    List<ColaboradorListResponse> buscaTodosColaboradores();
}
