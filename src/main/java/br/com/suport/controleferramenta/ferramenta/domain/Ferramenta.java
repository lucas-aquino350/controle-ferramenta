package br.com.suport.controleferramenta.ferramenta.domain;

import br.com.suport.controleferramenta.ferramenta.application.api.FerramentaRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String referencia;
    @NotBlank
    private String modelo;
    @NotBlank
    private String acessorios;
    @NotNull
    private Integer quantidade;
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
        this.quantidade = ferramentaRequest.getQuantidade();
        this.funcao = ferramentaRequest.getFuncao();
        this.dataHoraCadastro = LocalDateTime.now();
    }
}