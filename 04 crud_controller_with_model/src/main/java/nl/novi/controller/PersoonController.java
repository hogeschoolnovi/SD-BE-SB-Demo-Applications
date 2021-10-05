package nl.novi.controller;

import nl.novi.model.Persoon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

@RestController
public class PersoonController {

    private static List<Persoon> personen = new ArrayList<>();

    @GetMapping(value = "/personen")
    public ResponseEntity getPersonen() {
        return ResponseEntity.ok(personen);
    }

    @GetMapping(value = "/personen/{id}")
    public ResponseEntity getPersoon(@PathVariable int id) {
        return ResponseEntity.ok(personen.get(id));
    }

    @PostMapping(value = "/personen")
    public ResponseEntity addPersoon(@RequestBody Persoon persoon) {
        Persoon lastPersoon = personen.stream().max(comparing(Persoon::getId)).get();
        Long newId = lastPersoon.getId() + 1;
        persoon.setId(newId);
        personen.add(persoon);
        return ResponseEntity.ok("Toegevoegd met id " + newId);
    }

    @DeleteMapping(value = "/personen/{id}")
    public ResponseEntity deletePersoon(@PathVariable int id) {
        personen.remove(id);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/personen/{id}")
    public ResponseEntity updatePersoon(@PathVariable int id, @RequestBody Persoon persoon) {
        persoon.setId(id);
        personen.set(id, persoon);
        return ResponseEntity.ok("Aangepast");
    }

}
