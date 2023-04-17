package br.com.suport.controleferramenta.colaborador.application.api;

import lombok.Value;
import javax.validation.constraints.NotBlank;

@Value
public class ColaboradorAlteracaoRequest {
    @NotBlank
    private String cargo;
    @NotBlank
    private String setor;
}