package org.sid.repository;

import org.sid.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository {

    City findByName(String name);

    @Query("SELECT c FROM City c WHERE lower(trim(c.name)) LIKE :x")
    Page<City> findByName(@Param("x") String keyword, Pageable pageable);

    @Query("SELECT c FROM City c WHERE c.state.id LIKE :s AND lower(trim(c.name)) LIKE :x")
    Page<City> findByState(@Param("s") Long id, @Param("x") String keyword, Pageable pageable);

    @Query("SELECT c FROM City c WHERE c.state.id LIKE :s AND lower(trim(c.name)) LIKE :x")
    Page<City> findByCountry(@Param("s") Long id, @Param("x") String keyword, Pageable pageable);

}
