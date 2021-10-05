package nl.novi.controller;

import nl.novi.exceptions.RecordNotFoundException;
import nl.novi.model.Persoon;

import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.OK).body(personen);
    }

    @GetMapping(value = "/personen/{id}")
    public ResponseEntity getPersoon(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personen.get(id));
        }
        catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PostMapping(value = "/personen")
    public ResponseEntity addPersoon(@RequestBody Persoon persoon) {
        Persoon lastPersoon = personen.stream().max(comparing(Persoon::getId)).get();
        Long newId = lastPersoon.getId() + 1;
        persoon.setId(newId);
        personen.add(persoon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Toegevoegd met id " + newId);
    }

    @DeleteMapping(value = "/personen/{id}")
    public ResponseEntity deletePersoon(@PathVariable int id) {
        try {
            personen.remove(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Verwijderd");
        }
        catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PutMapping(value = "/personen/{id}")
    public ResponseEntity updatePersoon(@PathVariable int id, @RequestBody Persoon persoon) {
        try {
            persoon.setId(id);
            personen.set(id, persoon);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Aangepast");
        }
        catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

}
