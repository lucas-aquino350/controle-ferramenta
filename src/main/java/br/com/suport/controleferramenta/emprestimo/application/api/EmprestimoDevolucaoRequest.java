package br.com.suport.controleferramenta.emprestimo.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class EmprestimoDevolucaoRequest {
    @NotBlank
    private String observacaoDevolucao;
    @NotNull
    private LocalDate dataDevolucao;
}