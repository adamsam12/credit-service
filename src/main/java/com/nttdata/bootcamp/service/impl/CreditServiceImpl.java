package com.nttdata.bootcamp.service.impl;

import com.nttdata.bootcamp.model.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditServiceImpl {

    Flux<Credit> getAllCredits();

    Mono<Credit> getByIdCredit(String id);

    Mono<Credit> createCredit(Credit credit);

}
