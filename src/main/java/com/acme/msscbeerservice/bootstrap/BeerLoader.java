package com.acme.msscbeerservice.bootstrap;

import com.acme.msscbeerservice.domain.Beer;
import com.acme.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
                .upc(BEER_1_UPC)
                .quantityOnHand(10)
                .price(new BigDecimal("12.95"))
                .build();

        Beer malka = Beer.builder()
                .beerName("Malka")
                .beerStyle("Lager")
                .upc(BEER_2_UPC)
                .quantityOnHand(12)
                .price(new BigDecimal("9.99"))
                .build();

        Beer shapira = Beer.builder()
                .beerName("Shapira")
                .beerStyle("IPA")
                .upc(BEER_3_UPC)
                .quantityOnHand(20)
                .price(new BigDecimal("4.87"))
                .build();

        Beer savedGoldstar = beerRepository.save(goldstar);
        System.out.println("Goldstar id: " + savedGoldstar.getId());
        beerRepository.save(malka);
        beerRepository.save(shapira);
    }
}
