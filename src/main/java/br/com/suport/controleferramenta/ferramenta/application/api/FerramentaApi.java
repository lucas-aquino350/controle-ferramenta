package br.com.suport.controleferramenta.ferramenta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/ferramenta")
public interface FerramentaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FerramentaResponse postFerramenta (@Valid @RequestBody FerramentaRequest ferramentaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<FerramentaListResponse> getTodasFerramentas();
}