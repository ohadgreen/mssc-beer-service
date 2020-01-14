package com.acme.msscbeerservice.web.converters;

import com.acme.msscbeerservice.domain.Beer;
import com.acme.msscbeerservice.web.model.BeerDto;
import com.acme.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerToBeerDtoTest {

    BeerToBeerDto beerToBeerDto = new BeerToBeerDto();

    @Test
    void beerToBeerDtoConverterTest() {
        Beer beer = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Negev")
                .beerStyle("Lager")
                .upc(111L)
                .build();

        BeerDto beerDto = beerToBeerDto.convert(beer);
        System.out.println("beerDto = " + beerDto);
        assertEquals(BeerStyle.LAGER, beerDto.getBeerStyle());
    }
}