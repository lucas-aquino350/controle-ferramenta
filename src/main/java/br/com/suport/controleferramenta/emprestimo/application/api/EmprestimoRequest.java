package br.com.suport.controleferramenta.emprestimo.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class EmprestimoRequest {

    @NotNull
    private UUID idFerramenta;
    @NotNull
    private UUID idColaborador;
    @NotBlank
    private String motivo;
    @NotBlank
    private String ordemDeServico;
    @NotNull
    private LocalDate dataRetirada;
    @NotNull
    private LocalDate dataDevolucao;

}