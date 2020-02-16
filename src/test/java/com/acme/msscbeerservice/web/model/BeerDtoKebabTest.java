package com.acme.msscbeerservice.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest {

    private BeerDto beerDtoTest;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void objectToJsonTest() throws JsonProcessingException {
        beerDtoTest = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Malka Aduma")
                .beerStyle(BeerStyle.PILSNER)
                .upc("123")
                .build();

        String beerDtoJsonString = objectMapper.writeValueAsString(beerDtoTest);
        System.out.println("beerDtoJsonString = " + beerDtoJsonString);
        Assertions.assertTrue(beerDtoJsonString.contains("beer-name"));
    }

    @Test
    void jsonDeserializeTest() throws JsonProcessingException {
        String jsonBeer = "{\"id\":\"322d3c40-d01d-404b-88f5-d98572c2e8a2\",\"version\":null,\"created-date\":null,\"updated-date\":null,\"beer-name\":\"Malka Behira\",\"beer-style\":\"PALE_ALE\",\"upc\":123,\"price\":null,\"quantity-on-hand\":null}";

        BeerDto beerDto = objectMapper.readValue(jsonBeer, BeerDto.class);
        System.out.println(beerDto.toString());

        Assertions.assertEquals("Malka Behira", beerDto.getBeerName());
    }
}
