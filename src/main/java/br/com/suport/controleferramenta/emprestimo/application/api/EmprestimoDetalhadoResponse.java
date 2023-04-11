package br.com.suport.controleferramenta.emprestimo.application.api;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import br.com.suport.controleferramenta.emprestimo.domain.Emprestimo;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class EmprestimoDetalhadoResponse {

    private UUID idEmprestimo;
    private UUID idFerramenta;
    private UUID idColaborador;
    private String motivo;
    private String ordemDeServico;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private String nomeColaborador;

    public EmprestimoDetalhadoResponse(Emprestimo emprestimo, Colaborador colaborador) {
        this.idEmprestimo = emprestimo.getIdEmprestimo();
        this.idFerramenta = emprestimo.getIdFerramenta();
        this.idColaborador = emprestimo.getIdColaborador();
        this.motivo = emprestimo.getMotivo();
        this.ordemDeServico = emprestimo.getOrdemDeServico();
        this.dataRetirada = emprestimo.getDataRetirada();
        this.dataDevolucao = emprestimo.getDataDevolucao();
        this.nomeColaborador = colaborador.getNomeCompleto();
    }
}