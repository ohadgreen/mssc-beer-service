package com.acme.msscbeerservice.web.converters;

import com.acme.msscbeerservice.domain.Beer;
import com.acme.msscbeerservice.web.model.BeerDto;
import com.acme.msscbeerservice.web.model.BeerStyle;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerToBeerDto implements Converter<Beer, BeerDto> {
    @Override
    public BeerDto convert(Beer beer) {
        return BeerDto.builder()
                .id(beer.getId())
                .beerName(beer.getBeerName())
                .beerStyle(BeerStyle.valueOf(beer.getBeerStyle().toUpperCase()))
                .upc(beer.getUpc())
                .build();
    }
}
