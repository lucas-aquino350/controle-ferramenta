package br.com.suport.controleferramenta.ferramenta.application.repository;

import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;

import java.util.List;

public interface FerramentaRepository {
    Ferramenta salva(Ferramenta ferramenta);
    List<Ferramenta> buscaTodasFerramentas();
}