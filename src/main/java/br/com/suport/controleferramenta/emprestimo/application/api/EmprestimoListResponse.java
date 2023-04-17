package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import br.com.suport.controleferramenta.emprestimo.domain.StatusEmprestimo;
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
    private String nomeColaborador;
    private String motivo;
    private Integer quantidadeEmprestada;
    private String ordemDeServico;
    private LocalDate dataRetirada;
    private StatusEmprestimo statusEmprestimo;
    private LocalDate dataDevolucao;
    private String observacaoDevolucao;

    public EmprestimoListResponse(Emprestimo emprestimo, Colaborador colaborador) {
        this.idEmprestimo = emprestimo.getIdEmprestimo();
        this.idFerramenta = emprestimo.getIdFerramenta();
        this.idColaborador = emprestimo.getIdColaborador();
        this.nomeColaborador = colaborador.getNomeCompleto();
        this.quantidadeEmprestada = emprestimo.getQuantidadeEmprestada();
        this.motivo = emprestimo.getMotivo();
        this.ordemDeServico = emprestimo.getOrdemDeServico();
        this.dataRetirada = emprestimo.getDataRetirada();
        this.statusEmprestimo = emprestimo.getStatusEmprestimo();
        this.dataDevolucao = emprestimo.getDataDevolucao();
        this.observacaoDevolucao = emprestimo.getObservacaoDevolucao();
    }
}