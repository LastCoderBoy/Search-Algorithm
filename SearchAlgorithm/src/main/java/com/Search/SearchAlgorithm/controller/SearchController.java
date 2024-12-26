package com.Search.SearchAlgorithm.controller;


import com.Search.SearchAlgorithm.model.Games;
import com.Search.SearchAlgorithm.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class SearchController {
    private final SearchService service;
    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Games>> searchGame(@RequestParam String text) {
        try {
            List<Games> games = service.searchGame(text);
            return games.isEmpty()
                    ? ResponseEntity.noContent().build()
                    : ResponseEntity.ok(games);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Games>> getAllGames() {
        List<Games> games = service.getAllGames();
        return games.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(games);
    }
}
