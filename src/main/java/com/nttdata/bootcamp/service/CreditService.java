package com.nttdata.bootcamp.service;

import com.nttdata.bootcamp.model.Credit;
import com.nttdata.bootcamp.repository.CreditRepository;
import com.nttdata.bootcamp.service.impl.CreditServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditService implements CreditServiceImpl {

    private final CreditRepository creditRepository;


    @Override
    public Flux<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> getByIdCredit(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Mono<Credit> createCredit(Credit credit) {
        return creditRepository.save(credit);
    }
}
