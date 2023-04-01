package br.com.suport.controleferramenta.ferramenta.domain;

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

    public Ferramenta(UUID idFerramenta, String nome, String marca, String referencia, String modelo, String acessorios, Integer quantidade, String funcao, LocalDateTime dataHoraCadastro) {
        this.idFerramenta = UUID.randomUUID();
        this.nome = nome;
        this.marca = marca;
        this.referencia = referencia;
        this.modelo = modelo;
        this.acessorios = acessorios;
        this.quantidade = quantidade;
        this.funcao = funcao;
        this.dataHoraCadastro = dataHoraCadastro;
    }
}