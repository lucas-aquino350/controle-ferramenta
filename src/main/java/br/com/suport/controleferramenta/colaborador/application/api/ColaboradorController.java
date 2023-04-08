package br.com.suport.controleferramenta.colaborador.application.api;

import br.com.suport.controleferramenta.colaborador.application.service.ColaboradorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ColaboradorController implements ColaboradorApi {

    private final ColaboradorService colaboradorService;

    @Override
    public ColaboradorResponse postColaborador(ColaboradorRequest colaboradorRequest) {
        log.info("[inicia] ColaboradorController -  postColaborador");
        ColaboradorResponse colaboradorCriado = colaboradorService.criaColaborador(colaboradorRequest);
        log.info("[finaliza] ColaboradorController -  postColaborador");
        return colaboradorCriado;
    }

    @Override
    public List<ColaboradorListResponse> getTodosColaboradores() {
        log.info("[inicia] ColaboradorController -  getTodosColaboradores");
        List<ColaboradorListResponse> colaboradores = colaboradorService.buscaTodosColaboradores();
        log.info("[finaliza] ColaboradorController -  getTodosColaboradores");
        return colaboradores;
    }

    @Override
    public ColaboradorDetalhadoResponse getColaboradorAtravesId(UUID idColaborador) {
        log.info("[inicia] ColaboradorController -  getColaboradorAtravesId");
        log.info("[idColaborador] {}", idColaborador);
        ColaboradorDetalhadoResponse colaborador = colaboradorService.buscaColaboradorPorId(idColaborador);
        log.info("[finaliza] ColaboradorController -  getColaboradorAtravesId");
        return colaborador;
    }
}
