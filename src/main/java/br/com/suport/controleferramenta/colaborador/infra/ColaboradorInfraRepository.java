package br.com.suport.controleferramenta.colaborador.infra;

import br.com.suport.controleferramenta.colaborador.application.repository.ColaboradorRepository;
import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import br.com.suport.controleferramenta.ferramenta.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ColaboradorInfraRepository implements ColaboradorRepository {
    private final ColaboradorMongoSpringRepository colaboradorMongoSpringRepository;

    @Override
    public Colaborador salva(Colaborador colaborador) {
        log.info("[inicia] ColaboradorInfraRepository -  salva");
        colaboradorMongoSpringRepository.save(colaborador);
        log.info("[finaliza] ColaboradorInfraRepository -  salva");
        return colaborador;
    }

    @Override
    public List<Colaborador> buscaTodosColaboradores() {
        log.info("[inicia] ColaboradorInfraRepository -  buscaTodosColaboradores");
        List<Colaborador> todosColaboradores = colaboradorMongoSpringRepository.findAll();
        log.info("[finaliza] ColaboradorInfraRepository -  buscaTodosColaboradores");
        return todosColaboradores;
    }

    @Override
    public Colaborador buscaColaboradorPorId(UUID idColaborador) {
        log.info("[inicia] ColaboradorInfraRepository -  buscaColaboradorPorId");
        Colaborador colaborador = colaboradorMongoSpringRepository.findById(idColaborador)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Colaborador não encontrado!"));
        log.info("[finaliza] ColaboradorInfraRepository -  buscaColaboradorPorId");
        return colaborador;
    }

    @Override
    public void deletaColaborador(Colaborador colaborador) {
        log.info("[inicia] ColaboradorInfraRepository -  deletaColaborador");
        colaboradorMongoSpringRepository.delete(colaborador);
        log.info("[finaliza] ColaboradorInfraRepository -  deletaColaborador");
    }
}