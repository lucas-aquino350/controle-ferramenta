package br.com.suport.controleferramenta.emprestimo.domain;

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
    @NotNull
    private LocalDate dataDevolucao;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Emprestimo(UUID idEmprestimo, UUID idFerramenta, UUID idColaborador, String motivo, String ordemDeServico, LocalDate dataRetirada) {
        this.idEmprestimo = idEmprestimo;
        this.idFerramenta = idFerramenta;
        this.idColaborador = idColaborador;
        this.motivo = motivo;
        this.ordemDeServico = ordemDeServico;
        this.dataRetirada = dataRetirada;
    }
}