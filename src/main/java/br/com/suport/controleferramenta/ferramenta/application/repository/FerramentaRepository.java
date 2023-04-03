package br.com.suport.controleferramenta.ferramenta.application.repository;

import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;

import java.util.List;
import java.util.UUID;

public interface FerramentaRepository {
    Ferramenta salva(Ferramenta ferramenta);
    List<Ferramenta> buscaTodasFerramentas();
    Ferramenta buscaFerramentaPorId(UUID idFerramenta);
    void deleta(Ferramenta ferramenta);
}