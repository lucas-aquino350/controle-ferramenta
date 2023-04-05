package br.com.suport.controleferramenta.colaborador.domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Colaborador")
public class Colaborador {

    @Id
    private UUID idColaborador;
    @NotBlank
    private String nomeCompleto;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String cargo;
    @NotBlank
    private String setor;

    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Colaborador(UUID idColaborador, String nomeCompleto, String cpf, String cargo, String setor) {
        this.idColaborador = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.cargo = cargo;
        this.setor = setor;
        this.dataHoraCadastro = LocalDateTime.now();
    }
}