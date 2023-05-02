package br.com.suport.controleferramenta.ferramenta.application.api;

import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;
import lombok.Value;

@Value
public class FerramentaDetalhadaResponse {
    private String nome;
    private String marca;
    private String referencia;
    private String modelo;
    private String acessorios;
    private Integer quantidadeEstoque;
    private String funcao;

    public FerramentaDetalhadaResponse(Ferramenta ferramenta) {
        this.nome = ferramenta.getNome();
        this.marca = ferramenta.getMarca();
        this.referencia = ferramenta.getReferencia();
        this.modelo = ferramenta.getModelo();
        this.acessorios = ferramenta.getAcessorios();
        this.quantidadeEstoque = ferramenta.getQuantidadeEstoque();
        this.funcao = ferramenta.getFuncao();
    }
}