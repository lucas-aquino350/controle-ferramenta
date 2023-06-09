package br.com.suport.controleferramenta.colaborador.application.api;

import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Value
public class ColaboradorRequest {

    @NotBlank
    private String nomeCompleto;
    @CPF
    @NotBlank
    @Indexed(unique = true)
    private String cpf;
    @NotBlank
    private String cargo;
    @NotBlank
    private String setor;
}