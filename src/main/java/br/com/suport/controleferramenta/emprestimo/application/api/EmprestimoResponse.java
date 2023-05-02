package br.com.suport.controleferramenta.emprestimo.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class EmprestimoResponse {
    private UUID idEmprestimo;
}