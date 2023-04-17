package br.com.suport.controleferramenta.colaborador.application.service;

import br.com.suport.controleferramenta.colaborador.application.api.*;
import br.com.suport.controleferramenta.colaborador.application.repository.ColaboradorRepository;
import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ColaboradorApplicationService implements ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    @Override
    public ColaboradorResponse criaColaborador(ColaboradorRequest colaboradorRequest) {
        log.info("[inicia] ColaboradorApplicationService -  criaColaborador");
        Colaborador colaborador = colaboradorRepository.salva(new Colaborador(colaboradorRequest));
        log.info("[finaliza] ColaboradorApplicationService -  criaColaborador");
        return ColaboradorResponse
                .builder().idColaborador(colaborador.getIdColaborador())
                .build();
    }

    @Override
    public List<ColaboradorListResponse> buscaTodosColaboradores() {
        log.info("[inicia] ColaboradorApplicationService -  buscaTodosColaboradores");
        List<Colaborador> colaboradores = colaboradorRepository.buscaTodosColaboradores();
        log.info("[finaliza] ColaboradorApplicationService -  buscaTodosColaboradores");
        return ColaboradorListResponse.converte(colaboradores);
    }

    @Override
    public ColaboradorDetalhadoResponse buscaColaboradorPorId(UUID idColaborador) {
        log.info("[inicia] ColaboradorApplicationService -  buscaColaboradorPorId");
        Colaborador colaborador = colaboradorRepository.buscaColaboradorPorId(idColaborador);
        log.info("[finaliza] ColaboradorApplicationService -  buscaColaboradorPorId");
        return new ColaboradorDetalhadoResponse(colaborador);
    }

    @Override
    public void deletaColaboradorPorId(UUID idColaborador) {
        log.info("[inicia] ColaboradorApplicationService -  deletaColaboradorPorId");
        Colaborador colaborador = colaboradorRepository.buscaColaboradorPorId(idColaborador);
        colaboradorRepository.deletaColaborador(colaborador);
        log.info("[finaliza] ColaboradorApplicationService -  deletaColaboradorPorId");
    }

    @Override
    public void alteraColaborador(UUID idColaborador, ColaboradorAlteracaoRequest colaboradorAlteracaoRequest) {
        log.info("[inicia] ColaboradorApplicationService -  alteraColaborador");
        Colaborador colaborador = colaboradorRepository.buscaColaboradorPorId(idColaborador);
        colaborador.altera(colaboradorAlteracaoRequest);
        colaboradorRepository.salva(colaborador);
        log.info("[finaliza] ColaboradorApplicationService -  alteraColaborador");
    }
}