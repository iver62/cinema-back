package org.sid.service;

import org.sid.domain.Country;
import org.sid.filters.QueryParameters;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {

    Country getCountry(Long id) throws SQLException;

    List<Country> getCountries(QueryParameters queryParameters) throws SQLException;

    boolean getCountryByLabel(Country country) throws SQLException;

    Country createCountry(Country country) throws SQLException;

    Country updateCountry(Country country) throws SQLException;

    Long deleteCountry(Long id) throws SQLException;

    Long countCountries(QueryParameters queryParameters) throws SQLException;
}
