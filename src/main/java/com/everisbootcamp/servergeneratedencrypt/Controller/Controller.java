package com.everisbootcamp.servergeneratedencrypt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everisbootcamp.servergeneratedencrypt.service.Service;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class Controller {
	@Autowired
	private Service service;
	
    @GetMapping("/generated-number/{size}")
    public Mono< ResponseEntity<String> > generatedNumber(@PathVariable("size") int size){
        return service
        		.generatedNumber(size)
        		.map(s-> ResponseEntity.ok().body(s) )
        		.defaultIfEmpty(ResponseEntity
        		.internalServerError().build());
    }
	
    @GetMapping("/encript-password/{password}")
    public Mono< ResponseEntity<String> > encriptPassword(@PathVariable("password") String password){
        return service
        		.encriptPassword(password)
        		.map(s-> ResponseEntity.ok().body(s) )
        		.defaultIfEmpty(ResponseEntity
        		.internalServerError().build());
    }
}
