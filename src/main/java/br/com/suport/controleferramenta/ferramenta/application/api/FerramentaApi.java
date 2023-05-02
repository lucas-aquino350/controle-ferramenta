package br.com.suport.controleferramenta.ferramenta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/ferramenta")
public interface FerramentaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FerramentaResponse postFerramenta (@Valid @RequestBody FerramentaRequest ferramentaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<FerramentaListResponse> getTodasFerramentas();

    @GetMapping(value = "/{idFerramenta}")
    @ResponseStatus(code = HttpStatus.OK)
    FerramentaDetalhadaResponse getFerramentaAtravesId (@PathVariable UUID idFerramenta);

    @DeleteMapping(value = "/{idFerramenta}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaFerramentaAtravesID (@PathVariable UUID idFerramenta);

    @PatchMapping(value = "/{idFerramenta}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraFerramenta (@PathVariable UUID idFerramenta,
                             @Valid @RequestBody FerramentaAlteracaoRequest ferramentaAlteracaoRequest);
}