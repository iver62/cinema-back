package org.sid.repository;

import org.sid.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository {

    public Movie findByFrenchTitle(String title);

    @Query("SELECT m FROM Movie m WHERE m.frenchTitle LIKE :x ORDER BY m.frenchTitle")
    public List<Movie> search(@Param("x") String keyword);

}
