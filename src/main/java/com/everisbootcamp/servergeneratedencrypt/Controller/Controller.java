package com.everisbootcamp.servergeneratedencrypt.Controller;

import com.everisbootcamp.servergeneratedencrypt.service.ServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private ServiceLogic service;

    @GetMapping("/generatednumber")
    public Mono<ResponseEntity<String>> generatedNumber(@RequestParam int size) {
        return service
            .generatedNumber(size)
            .map(s -> ResponseEntity.ok().body(s))
            .defaultIfEmpty(ResponseEntity.internalServerError().build());
    }

    @GetMapping("/encriptpassword")
    public Mono<ResponseEntity<String>> encriptPassword(@RequestParam String value) {
        return service
            .encriptPassword(value)
            .map(s -> ResponseEntity.ok().body(s))
            .defaultIfEmpty(ResponseEntity.internalServerError().build());
    }
}
