package org.sid.service;

import org.sid.domain.City;
import org.sid.filters.QueryParameters;
import org.sid.repository.CityRepository;
import org.sid.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCity(Long id) throws SQLException {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> getCities(QueryParameters queryParameters) throws SQLException {
        return cityRepository.findAll(queryParameters);
    }

    @Override
    public boolean getCityByLabel(City city) throws SQLException {
        return cityRepository.findByLabel(city);
    }

    @Override
    public City createCity(City city) throws SQLException {
        city.setLabel(Utils.capitalizeFirstLetter(city.getLabel()));
        return cityRepository.create(city);
    }

    @Override
    public City updateCity(City city) throws SQLException {
        city.setLabel(Utils.capitalizeFirstLetter(city.getLabel()));
        return cityRepository.update(city);
    }

    @Override
    public Long deleteCity(Long id) throws SQLException {
        return cityRepository.deleteById(id);
    }

    @Override
    public Long countCities(QueryParameters queryParameters) throws SQLException {
        return cityRepository.count(queryParameters);
    }
}
