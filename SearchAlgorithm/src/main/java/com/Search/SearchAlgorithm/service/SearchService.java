package com.Search.SearchAlgorithm.service;

import com.Search.SearchAlgorithm.model.Games;
import com.Search.SearchAlgorithm.repsotiry.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final SearchRepository repository;
    @Autowired
    public SearchService(SearchRepository repository) {
        this.repository = repository;
    }

    public List<Games> searchGame(String text) {
        if(text == null || text.trim().isEmpty()){
            throw new IllegalArgumentException("Search text cannot be empty");
        }
        System.out.println("Search text: " + text);
        return repository.searchByTitleContains(text);
    }

    public List<Games> getAllGames() {
        return repository.findAll();
    }
}
