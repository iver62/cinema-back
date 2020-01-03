package org.sid.service;

import org.sid.domain.City;
import org.sid.repository.CityRepository;
import org.sid.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

//    private CityRepository cityRepository;
//
//    @Autowired
//    public CityServiceImpl(CityRepository cityRepository) {
//        this.cityRepository = cityRepository;
//    }
//
//    @Override
//    public City getCity(final Long id) {
//        return cityRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Page<City> getCities(String name, Pageable pageable) {
//        return cityRepository.findByName(name, pageable);
//    }
//
//    @Override
//    public Page<City> getCitiesByState(Long id, String name, Pageable pageable) {
//        return cityRepository.findByState(id, name, pageable);
//    }
//
//    @Override
//    public Page<City> getCitiesByCountry(Long id, String name, Pageable pageable) {
//        return cityRepository.findByCountry(id, name, pageable);
//    }
//
//    @Override
//    public City getCityByName(final String name) {
//        return cityRepository.findByName(name);
//    }
//
//    @Override
//    public City createCity(final City city) {
//        city.setLabel(Utils.capitalizeFirstLetter(city.getLabel()));
//        return cityRepository.save(city);
//    }
//
//    @Override
//    public City updateCity(final Long id, final City city) {
//        city.setId(id);
//        city.setLabel(Utils.capitalizeFirstLetter(city.getLabel()));
//        return cityRepository.save(city);
//    }
//
//    @Override
//    public void deleteCity(final Long id) {
//        cityRepository.deleteById(id);
//    }
}
