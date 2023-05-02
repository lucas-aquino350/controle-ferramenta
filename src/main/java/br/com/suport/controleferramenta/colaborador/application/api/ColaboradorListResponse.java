package br.com.suport.controleferramenta.colaborador.application.api;

import br.com.suport.controleferramenta.colaborador.domain.Colaborador;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ColaboradorListResponse {

    private UUID idColaborador;
    private String nomeCompleto;
    private String cpf;
    private String cargo;
    private String setor;

    public static List<ColaboradorListResponse> converte(List<Colaborador> colaboradores) {
        return colaboradores.stream().map(ColaboradorListResponse::new).collect(Collectors.toList());
    }

    public ColaboradorListResponse(Colaborador colaborador) {
        this.nomeCompleto = colaborador.getNomeCompleto();
        this.cpf = colaborador.getCpf();
        this.cargo = colaborador.getCargo();
        this.setor = colaborador.getSetor();
        this.idColaborador = colaborador.getIdColaborador();
    }
}