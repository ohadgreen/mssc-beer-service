package com.acme.msscbeerservice.bootstrap;

import com.acme.msscbeerservice.domain.Beer;
import com.acme.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {

    final BeerRepository beerRepository;
    final UUID UUID_1 = UUID.fromString("e63f9029-5c0e-47ec-8fb5-98cc0c37201c");
    final UUID UUID_2 = UUID.fromString("1aa9e03b-af78-45c1-8127-2e29fc3a250f");
    final UUID UUID_3 = UUID.fromString("8b8e6c8f-591b-48b7-903b-d89a9de791bf");

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
                .id(UUID_1)
                .beerName("Goldstar")
                .beerStyle("Lager")
                .upc(10000L)
                .quantityOnHand(10)
                .build();

        Beer malka = Beer.builder()
                .id(UUID_2)
                .beerName("Malka")
                .beerStyle("Lager")
                .upc(10001L)
                .quantityOnHand(12)
                .build();

        Beer shapira = Beer.builder()
                .id(UUID_3)
                .beerName("Shapira")
                .beerStyle("IPA")
                .upc(10002L)
                .quantityOnHand(20)
                .build();

        Beer savedGoldstar = beerRepository.save(goldstar);
        System.out.println("Goldstar id: " + savedGoldstar.getId());
        beerRepository.save(malka);
        beerRepository.save(shapira);
    }
}
