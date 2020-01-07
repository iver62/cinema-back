package org.sid.controller;

import org.sid.domain.Country;
import org.sid.domain.dto.CountriesDTO;
import org.sid.filters.RequestOptions;
import org.sid.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "api/country")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * url: api/country/:id
     *
     * @param principal
     * @param id
     * @return
     * @throws SQLException
     */
    @GetMapping("{id}")
    public Country getCountry(final Principal principal, @PathVariable final Long id) throws SQLException {
        return countryService.getCountry(id);
    }

    /**
     * url: api/country/all
     *
     * @param principal
     * @param requestOptions
     * @return
     * @throws SQLException
     */
    @PostMapping("/all")
    public CountriesDTO getCountries(final Principal principal, @RequestBody final RequestOptions requestOptions) throws SQLException {
        CountriesDTO countriesDTO = new CountriesDTO();
        if (requestOptions.isWithCount()) {
            countriesDTO.setCount(countryService.countCountries(requestOptions.getQueryParameters()));
        }
        countriesDTO.setCountries(countryService.getCountries(requestOptions.getQueryParameters()));
        return countriesDTO;
    }

    /**
     * url: api/country/search
     *
     * @param principal
     * @param country
     * @return
     * @throws SQLException
     */
    @PostMapping("search")
    public boolean getCountryByLabel(final Principal principal, @RequestBody @Valid Country country) throws SQLException {
        return countryService.getCountryByLabel(country);
    }

    /**
     * url: api/country
     *
     * @param principal
     * @param country
     * @return
     * @throws SQLException
     */
    @PostMapping
    public Country createCountry(final Principal principal, @Valid @RequestBody final Country country) throws SQLException {
        return countryService.createCountry(country);
    }

    /**
     * url: api/country
     *
     * @param principal
     * @param country
     * @return
     * @throws SQLException
     */
    @PutMapping
    public Country updateCountry(final Principal principal, @Valid @RequestBody final Country country) throws SQLException {
        return countryService.updateCountry(country);
    }

    /**
     * url: api/country/:id
     *
     * @param principal
     * @param id
     * @return
     * @throws SQLException
     */
    @DeleteMapping("{id}")
    public Long deleteCountry(final Principal principal, @PathVariable final Long id) throws SQLException {
        return countryService.deleteCountry(id);
    }

}
