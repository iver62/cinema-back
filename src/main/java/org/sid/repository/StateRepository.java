package org.sid.repository;

import org.sid.domain.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository {

    State findByName(String name);

    @Query("SELECT s FROM State s WHERE lower(trim(s.name)) LIKE :x")
    Page<State> findByName(@Param("x") String keyword, Pageable pageable);

    @Query("SELECT s FROM State s WHERE s.country.id LIKE :c AND lower(trim(s.name)) LIKE :x")
    Page<State> findByCountry(@Param("c") Long id, @Param("x") String keyword, Pageable pageable);

}
