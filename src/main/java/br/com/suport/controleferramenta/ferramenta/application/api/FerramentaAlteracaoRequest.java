package br.com.suport.controleferramenta.ferramenta.application.api;

import lombok.Value;

@Value
public class FerramentaAlteracaoRequest {

    private String nome;
    private String marca;
    private String referencia;
    private String modelo;
    private String acessorios;
    private String funcao;
}