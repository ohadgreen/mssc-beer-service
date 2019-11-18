package com.acme.msscbeerservice.web.controller;

import com.acme.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
        BeerDto hogarden = BeerDto.builder().beerName("Hogarden").build();
        return new ResponseEntity<>(hogarden, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
        // todo: implement
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDto beerDto) {
        // todo: implement
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
