package sg.edu.nus.iss.day16_workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import sg.edu.nus.iss.day16_workshop.model.*;
import sg.edu.nus.iss.day16_workshop.repo.*;

@RestController
@RequestMapping("/api/boardgames")
public class BoardgameController {

    @Autowired
    BoardgameRepo bgRepo;


    @PostMapping
    public ResponseEntity<Boardgame> save(@RequestBody Boardgame boardgame) {
        Boardgame bg = bgRepo.save(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boardgame> findById(@PathVariable Integer id) {
        Boardgame bg = bgRepo.findBoardgameById(id);

        if (bg == null) {
            return new ResponseEntity<Boardgame>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<Boardgame> update(@RequestBody Boardgame boardgame) {
        Boardgame bg = bgRepo.update(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

}
