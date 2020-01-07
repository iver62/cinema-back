package org.sid.service;

import org.sid.domain.City;
import org.sid.filters.QueryParameters;

import java.sql.SQLException;
import java.util.List;

public interface CityService {

    City getCity(Long id) throws SQLException;

    List<City> getCities(QueryParameters queryParameters) throws SQLException;

    boolean getCityByLabel(City city) throws SQLException;

    City createCity(City city) throws SQLException;

    City updateCity(City city) throws SQLException;

    Long deleteCity(Long id) throws SQLException;

    Long countCities(QueryParameters queryParameters) throws SQLException;
}
