package org.sid.repository;

import org.sid.domain.Country;
import org.sid.filters.QueryParameters;

import java.sql.SQLException;
import java.util.List;

public interface CountryRepository extends MainRepository {

    Country findById(Long id) throws SQLException;

    List<Country> findAll(QueryParameters queryParameters) throws SQLException;

    boolean findByLabel(Country country) throws SQLException;

    Country create(Country country) throws SQLException;

    Country update(Country country) throws SQLException;


}
