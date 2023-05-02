package br.com.suport.controleferramenta.ferramenta.application.api;

import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class FerramentaRequest {
    @NotBlank
    private String nome;
    private String marca;
    @NotBlank
    @Indexed(unique = true)
    private String referencia;
    @NotBlank
    private String modelo;
    @NotBlank
    private String acessorios;
    @NotNull
    private Integer quantidadeEstoque;
    @NotBlank
    private String funcao;
}