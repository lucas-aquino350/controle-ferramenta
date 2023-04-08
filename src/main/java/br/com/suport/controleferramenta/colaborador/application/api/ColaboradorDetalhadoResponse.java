package br.com.suport.controleferramenta.colaborador.application.api;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import lombok.Value;

@Value
public class ColaboradorDetalhadoResponse {
    private String nomeCompleto;
    private String cpf;
    private String cargo;
    private String setor;

    public ColaboradorDetalhadoResponse(Colaborador colaborador) {
        this.nomeCompleto = colaborador.getNomeCompleto();
        this.cpf = colaborador.getCpf();
        this.cargo = colaborador.getCargo();
        this.setor = colaborador.getSetor();
    }
}