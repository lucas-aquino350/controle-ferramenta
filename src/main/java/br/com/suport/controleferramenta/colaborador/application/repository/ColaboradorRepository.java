package br.com.suport.controleferramenta.colaborador.application.repository;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;

import java.util.List;

public interface ColaboradorRepository {
    Colaborador salva(Colaborador colaborador);
    List<Colaborador> buscaTodosColaboradores();
}
