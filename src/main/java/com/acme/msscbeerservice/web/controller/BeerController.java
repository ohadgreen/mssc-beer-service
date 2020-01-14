package com.acme.msscbeerservice.web.controller;

import com.acme.msscbeerservice.domain.Beer;
import com.acme.msscbeerservice.repositories.BeerRepository;
import com.acme.msscbeerservice.web.converters.BeerToBeerDto;
import com.acme.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerRepository beerRepository;
    private final BeerToBeerDto beerToBeerDtoConverter;

    public BeerController(BeerRepository beerRepository, BeerToBeerDto beerToBeerDtoConverter) {
        this.beerRepository = beerRepository;
        this.beerToBeerDtoConverter = beerToBeerDtoConverter;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BeerDto>> getAll() {
        Iterable<Beer> allBeerIterable = beerRepository.findAll();
        List<BeerDto> beerDtoList = new ArrayList<>();

        allBeerIterable.forEach(beer -> beerDtoList.add(beerToBeerDtoConverter.convert(beer)));
        return new ResponseEntity<>(beerDtoList, HttpStatus.OK);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
        BeerDto hogarden = BeerDto.builder().beerName("Hogarden").build();
        return new ResponseEntity<>(hogarden, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        // todo: implement
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId")UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        // todo: implement
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
