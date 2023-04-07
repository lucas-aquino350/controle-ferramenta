package br.com.suport.controleferramenta.colaborador.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
public class ColaboradorResponse {
    private UUID idColaborador;
}
