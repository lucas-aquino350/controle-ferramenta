package br.com.suport.controleferramenta.ferramenta.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class FerramentaResponse {
    private UUID idFerramenta;
}
