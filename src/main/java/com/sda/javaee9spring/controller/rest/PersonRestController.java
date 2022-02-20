package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
public class PersonRestController {

    private final RealPersonService personService;

    @Autowired
    public PersonRestController(RealPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPersons() {
        log.info("findALlPersons");

        return personService.readAllPersonEntities();
    }

    // /persons/1
    // /persons/10
    // /persons/12345
    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> findPersonEntityById(@PathVariable("id") Long personId) {
        log.info("trying to find person entity by id: [{}]", personId);
        var personEntity = personService.readPersonEntityById(personId);
        return personEntity.map(personEntity1 -> ResponseEntity.ok(personEntity1))   // Optional<PersonEntity> -> Optional<ResponseEntity>
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    // /persons/1 - using DELETE HTTP VERB
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePersonEntityById(@PathVariable("id") Long id) {
        log.info("trying to delete person entity by id: [{}]", id);

        boolean deleted = personService.deletePersonEntityById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/persons")
    public ResponseEntity<?> createPersonEntity(@RequestBody PersonEntity newPersonToSave) {

        log.info("received new person to save: [{}]", newPersonToSave);
        boolean saved = personService.savePerson(newPersonToSave);


        if (saved) {

            return ResponseEntity.created(URI.create("/api/persons/%d".formatted(newPersonToSave.getId())))
                    .body(newPersonToSave);
        } else {
            return ResponseEntity.badRequest().body("You've sent me wrong data!!!");
        }

    }
}

