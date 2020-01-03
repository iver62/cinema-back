package org.sid.service;

import org.sid.domain.Country;
import org.sid.filters.QueryParameters;
import org.sid.repository.CountryRepository;
import org.sid.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import utils.MySort;

import java.sql.SQLException;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getCountry(final Long id) throws SQLException {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> getCountries(final QueryParameters queryParameters) throws SQLException {
        return countryRepository.findAll(queryParameters);
    }

    @Override
    public boolean getCountryByLabel(final Country country) throws SQLException {
        return countryRepository.findByLabel(country);
    }

    @Override
    public Country createCountry(final Country country) throws SQLException {
        country.setLabel(Utils.capitalizeFirstLetter(country.getLabel()));
        return countryRepository.create(country);
    }


    @Override
    public Country updateCountry(final Country country) throws SQLException {
        country.setLabel(Utils.capitalizeFirstLetter(country.getLabel()));
        return countryRepository.update(country);
    }

    @Override
    public Long deleteCountry(final Long id) throws SQLException {
        return countryRepository.deleteById(id);
    }

    @Override
    public Long countCountries(final QueryParameters queryParameters) throws SQLException {
        return countryRepository.count(queryParameters);
    }

    @Override
    public MySort getDefaultSort() {
        return MySort.builder().column("label").direction(Sort.Direction.ASC).build();
    }
}
