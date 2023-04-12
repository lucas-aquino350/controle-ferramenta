package br.com.suport.controleferramenta.emprestimo.domain;

import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoAlteracaoRequest;
import br.com.suport.controleferramenta.emprestimo.application.api.EmprestimoRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Emprestimo")
public class Emprestimo {

    @Id
    private UUID idEmprestimo;
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
    private LocalDate dataDevolucao;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Emprestimo(EmprestimoRequest emprestimoRequest) {
        this.idEmprestimo = UUID.randomUUID();
        this.idFerramenta = emprestimoRequest.getIdFerramenta();
        this.idColaborador = emprestimoRequest.getIdColaborador();
        this.motivo = emprestimoRequest.getMotivo();
        this.ordemDeServico = emprestimoRequest.getOrdemDeServico();
        this.dataRetirada = emprestimoRequest.getDataRetirada();
    }

    public void altera(EmprestimoAlteracaoRequest emprestimoAlteracaoRequest) {
        this.motivo = emprestimoAlteracaoRequest.getMotivo();
        this.ordemDeServico = emprestimoAlteracaoRequest.getOrdemDeServico();
    }
}