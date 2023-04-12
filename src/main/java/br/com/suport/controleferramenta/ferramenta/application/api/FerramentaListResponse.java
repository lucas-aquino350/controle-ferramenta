package br.com.suport.controleferramenta.ferramenta.application.api;

import br.com.suport.controleferramenta.ferramenta.domain.Ferramenta;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class FerramentaListResponse {
    private UUID idFerramenta;
    private String nome;
    private String marca;
    private String referencia;
    private String modelo;
    private String acessorios;
    private Integer quantidadeEstoque;
    private String funcao;

    public static List<FerramentaListResponse> converte(List<Ferramenta> ferramentas) {
        return ferramentas.stream().map(FerramentaListResponse::new).collect(Collectors.toList());
    }

    public FerramentaListResponse(Ferramenta ferramenta) {
        this.idFerramenta = ferramenta.getIdFerramenta();
        this.nome = ferramenta.getNome();
        this.marca = ferramenta.getMarca();
        this.referencia = ferramenta.getReferencia();
        this.modelo = ferramenta.getModelo();
        this.acessorios = ferramenta.getAcessorios();
        this.quantidadeEstoque = ferramenta.getQuantidadeEstoque();
        this.funcao = ferramenta.getFuncao();
    }
}