package br.com.suport.controleferramenta.ferramenta.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
public class FerramentaListResponse {
    private UUID idFerramenta;
    private String nome;
    private String marca;
    private String referencia;
    private String modelo;
    private String acessorios;
    private Integer quantidade;
    private String funcao;
}