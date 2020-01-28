package com.acme.msscbeerservice.bootstrap;

import com.acme.msscbeerservice.domain.Beer;
import com.acme.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {

    final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            this.initBeerObjects();
        }
        log.info("beers loaded: " + beerRepository.count());
    }

    private void initBeerObjects() {
        Beer goldstar = Beer.builder()
                .beerName("Goldstar")
                .beerStyle("Lager")
                .upc(10000L)
                .quantityOnHand(10)
                .build();

        Beer malka = Beer.builder()
                .beerName("Malka")
                .beerStyle("Lager")
                .upc(10001L)
                .quantityOnHand(12)
                .build();

        Beer shapira = Beer.builder()
                .beerName("Shapira")
                .beerStyle("IPA")
                .upc(10002L)
                .quantityOnHand(20)
                .build();

        beerRepository.save(goldstar);
        beerRepository.save(malka);
        beerRepository.save(shapira);
    }
}
