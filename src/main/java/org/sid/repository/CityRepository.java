package org.sid.repository;

import org.sid.domain.City;
import org.sid.filters.QueryParameters;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CityRepository extends MainRepository {

    City findById(Long id) throws SQLException;

    List<City> findAll(QueryParameters queryParameters) throws SQLException;

    boolean findByLabel(City city) throws SQLException;

    City create(City city) throws SQLException;

    City update(City city) throws SQLException;
}
