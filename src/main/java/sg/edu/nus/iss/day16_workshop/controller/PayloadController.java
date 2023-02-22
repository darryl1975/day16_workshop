package sg.edu.nus.iss.day16_workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import sg.edu.nus.iss.day16_workshop.repo.*;
import sg.edu.nus.iss.day16_workshop.model.*;

@RestController
@RequestMapping("/api/payloads")
public class PayloadController {

    @Autowired
    PayloadRepo payloadRepo;

    @PostMapping
    public ResponseEntity<Payload> save(@RequestBody Payload payload) {
        Payload pLoad = payloadRepo.save(payload);

        return new ResponseEntity<Payload>(pLoad, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payload>> findAll() {
        List<Payload> payloads = payloadRepo.findAll();

        return new ResponseEntity<List<Payload>>(payloads, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payload> findById(@PathVariable Integer id) {
        Payload pLoad = payloadRepo.findPayloadById(id);

        return new ResponseEntity<Payload>(pLoad, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        String result = payloadRepo.deletePayloadById(id);

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
