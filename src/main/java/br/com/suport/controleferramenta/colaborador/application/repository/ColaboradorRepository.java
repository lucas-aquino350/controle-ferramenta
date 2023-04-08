package br.com.suport.controleferramenta.colaborador.application.repository;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;

import java.util.List;
import java.util.UUID;

public interface ColaboradorRepository {
    Colaborador salva(Colaborador colaborador);
    List<Colaborador> buscaTodosColaboradores();
    Colaborador buscaColaboradorPorId(UUID idColaborador);
}
