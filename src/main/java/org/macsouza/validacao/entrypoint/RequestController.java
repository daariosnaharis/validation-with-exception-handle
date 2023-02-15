package org.macsouza.validacao.entrypoint;

import org.macsouza.validacao.entrypoint.domain.Request;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RequestController {

    @PostMapping(value = "/test",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTeste(@Valid @RequestBody Request request) {
        return ResponseEntity.ok("Este é apenas um teste!");
    }

}
