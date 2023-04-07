package br.com.suport.controleferramenta.colaborador.application.service;

import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorRequest;
import br.com.suport.controleferramenta.colaborador.application.api.ColaboradorResponse;
import br.com.suport.controleferramenta.colaborador.application.repository.ColaboradorRepository;
import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
