package br.com.suport.controleferramenta.emprestimo.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class EmprestimoAlteracaoRequest {

    private String motivo;
    private String ordemDeServico;
}