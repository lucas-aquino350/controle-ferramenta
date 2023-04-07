package br.com.suport.controleferramenta.colaborador.application.api;

import br.com.suport.controleferramenta.colaborador.application.service.ColaboradorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
