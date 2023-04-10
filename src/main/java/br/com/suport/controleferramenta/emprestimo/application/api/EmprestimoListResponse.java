package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EmprestimoListResponse {

    private UUID idEmprestimo;
    private UUID idFerramenta;
    private UUID idColaborador;
    private String motivo;
    private String ordemDeServico;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public static List<EmprestimoListResponse> converte(List<Emprestimo> emprestimos) {
        return emprestimos.stream().map(EmprestimoListResponse::new).collect(Collectors.toList());
    }

    public EmprestimoListResponse(Emprestimo emprestimo) {
        this.idEmprestimo = emprestimo.getIdEmprestimo();
        this.idFerramenta = emprestimo.getIdFerramenta();
        this.idColaborador = emprestimo.getIdColaborador();
        this.motivo = emprestimo.getMotivo();
        this.ordemDeServico = emprestimo.getOrdemDeServico();
        this.dataRetirada = emprestimo.getDataRetirada();
        this.dataDevolucao = emprestimo.getDataDevolucao();
    }
}
