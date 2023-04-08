package br.com.suport.controleferramenta.colaborador.application.service;

import br.com.suport.controleferramenta.colaborador.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ColaboradorService {
    ColaboradorResponse criaColaborador(ColaboradorRequest colaboradorRequest);
    List<ColaboradorListResponse> buscaTodosColaboradores();
    ColaboradorDetalhadoResponse buscaColaboradorPorId(UUID idColaborador);
    void deletaColaboradorPorId(UUID idColaborador);
    void alteraColaborador(UUID idColaborador, ColaboradorAlteracaoRequest colaboradorAlteracaoRequest);
}
