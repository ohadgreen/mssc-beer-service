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
import java.util.Optional;
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
        Optional<Beer> beer = beerRepository.findById(beerId);
        if (beer.isPresent()) {
            BeerDto beerDto = beerToBeerDtoConverter.convert(beerRepository.findById(beerId).get());
            return new ResponseEntity<>(beerDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/byUpc/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("upc") long upc) {
        Beer beer = beerRepository.findByUpc(upc);
        if (beer != null) {
            BeerDto beerDto = beerToBeerDtoConverter.convert(beer);
            return new ResponseEntity<>(beerDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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
