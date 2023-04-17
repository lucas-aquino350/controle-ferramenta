package br.com.suport.controleferramenta.ferramenta.domain;

import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaAlteracaoRequest;
import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaRequest;
import br.com.suport.controleferramenta.handler.APIException;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Ferramenta")
public class Ferramenta {

    @Id
    private UUID idFerramenta;
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

    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Ferramenta(FerramentaRequest ferramentaRequest) {
        this.idFerramenta = UUID.randomUUID();
        this.nome = ferramentaRequest.getNome();
        this.marca = ferramentaRequest.getMarca();
        this.referencia = ferramentaRequest.getReferencia();
        this.modelo = ferramentaRequest.getModelo();
        this.acessorios = ferramentaRequest.getAcessorios();
        this.quantidadeEstoque = ferramentaRequest.getQuantidadeEstoque();
        this.funcao = ferramentaRequest.getFuncao();
        this.dataHoraCadastro = LocalDateTime.now();
        this.dataHoraUltimaAlteracao = LocalDateTime.now();
    }

    public void altera(FerramentaAlteracaoRequest ferramentaAlteracaoRequest) {
        this.nome = ferramentaAlteracaoRequest.getNome();
        this.marca = ferramentaAlteracaoRequest.getMarca();
        this.referencia = ferramentaAlteracaoRequest.getReferencia();
        this.modelo = ferramentaAlteracaoRequest.getModelo();
        this.acessorios = ferramentaAlteracaoRequest.getAcessorios();
        this.funcao = ferramentaAlteracaoRequest.getFuncao();
    }

    public void atualizaEstoque(Integer quantidadeEmprestada) {
        if(quantidadeEmprestada > quantidadeEstoque ){
            throw APIException.build(HttpStatus.NOT_FOUND, "Não há ferramentas suficientes em estoque!");
        } else {
            quantidadeEstoque -= quantidadeEmprestada;
        }
    }

    public void devolveAoEstoque(Integer quantidadeEmprestada) {
        quantidadeEstoque += quantidadeEmprestada;
    }
}