package nl.novi.controller;

import nl.novi.service.SpelerService;
import nl.novi.model.Speler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpelerController {

    @Autowired
    private SpelerService spelerService;

    public SpelerController(SpelerService spelerService) {
        this.spelerService = spelerService;
    }

    @GetMapping(value = "/spelers")
    public ResponseEntity getSpelers() {
        Iterable<Speler> spelers;
        spelers = spelerService.findAll();
        return ResponseEntity.ok(spelers);
    }

    @GetMapping(value = "/spelers/{nr}")
    public ResponseEntity getSpeler(@PathVariable long nr) {
        Speler speler = spelerService.findById(nr);
        return ResponseEntity.ok(speler);
    }

    @PostMapping(value = "/spelers")
    public ResponseEntity addSpeler(@RequestBody Speler speler) {
        spelerService.save(speler);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/spelers/{nr}")
    public ResponseEntity deleteSpeler(@PathVariable long nr) {
        spelerService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/spelers/{nr}")
    public ResponseEntity updateSpeler(@PathVariable long nr, @RequestBody Speler speler) {
        return ResponseEntity.ok("Aangepast");
    }

}
