package br.com.suport.controleferramenta.colaborador.application.api;

import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Value
public class ColaboradorListResponse {

    private String nomeCompleto;
    private String cpf;
    private String cargo;
    private String setor;
}
