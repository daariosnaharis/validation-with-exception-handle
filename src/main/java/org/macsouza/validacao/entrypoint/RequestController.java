package org.macsouza.validacao.entrypoint;

import org.macsouza.validacao.entrypoint.domain.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RequestController {

    @GetMapping("/test")
    public ResponseEntity<String> getTeste(@Valid @RequestBody Request request) {
        return ResponseEntity.ok("Este é apenas um teste!");
    }

}
