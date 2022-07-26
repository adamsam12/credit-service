package com.nttdata.bootcamp.controller;

import com.nttdata.bootcamp.model.Credit;
import com.nttdata.bootcamp.service.CreditService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    private static final String CREDIT = "credit";

    @GetMapping(value = "/allCredits")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Credit> getAllCredits(){
        System.out.println("lista todas las tarjetas");
        return creditService.getAllCredits();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Credit> getCreditById(@PathVariable String id){
        System.out.println("Listar tarjetas  por Id");
        return creditService.getByIdCredit(id);
    }

    @PostMapping(value = "/create")
    @CircuitBreaker(name = CREDIT, fallbackMethod = "credit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Credit> createCredit(@RequestBody Credit credit){
        System.out.println("se creo tarjeta");
        return creditService.createCredit(credit);
    }

}
