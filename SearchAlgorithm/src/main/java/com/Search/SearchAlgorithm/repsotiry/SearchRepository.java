package com.Search.SearchAlgorithm.repsotiry;

import com.Search.SearchAlgorithm.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Games, Long> {
    @Query("SELECT g FROM Games g WHERE LOWER(g.title) LIKE LOWER(concat('%', :text, '%'))")
    List<Games> searchByTitleContains(@Param("text") String text);

}
