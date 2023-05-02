package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import br.com.suport.controleferramenta.emprestimo.domain.StatusEmprestimo;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class EmprestimoDetalhadoResponse {
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

    public EmprestimoDetalhadoResponse(Emprestimo emprestimo, Colaborador colaborador) {
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