package br.com.suport.controleferramenta.emprestimo.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
public class EmprestimoAlteracaoRequest {
    private String motivo;
    private String ordemDeServico;
    private LocalDate dataDevolucao;
}