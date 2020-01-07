package org.sid.controller;

import org.sid.domain.City;
import org.sid.domain.dto.CitiesDTO;
import org.sid.filters.RequestOptions;
import org.sid.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "api/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * url: api/city/:id
     *
     * @param principal
     * @param id
     * @return
     * @throws SQLException
     */
    @GetMapping("{id}")
    public City getCity(final Principal principal, @PathVariable final Long id) throws SQLException {
        return cityService.getCity(id);
    }

    /**
     * url: api/city/all
     *
     * @param principal
     * @param requestOptions
     * @return
     * @throws SQLException
     */
    @PostMapping("/all")
    public CitiesDTO getCities(final Principal principal, @RequestBody final RequestOptions requestOptions) throws SQLException {
        CitiesDTO citiesDTO = new CitiesDTO();
        if (requestOptions.isWithCount()) {
            citiesDTO.setCount(cityService.countCities(requestOptions.getQueryParameters()));
        }
        citiesDTO.setCities(cityService.getCities(requestOptions.getQueryParameters()));
        return citiesDTO;
    }

    /**
     * url: api/city/search
     *
     * @param principal
     * @param city
     * @return
     * @throws SQLException
     */
    @PostMapping("search")
    public boolean getCityByLabel(final Principal principal, @RequestBody @Valid City city) throws SQLException {
        return cityService.getCityByLabel(city);
    }

    /**
     * url: api/city
     *
     * @param principal
     * @param city
     * @return
     * @throws SQLException
     */
    @PostMapping
    public City createCity(final Principal principal, @Valid @RequestBody final City city) throws SQLException {
        return cityService.createCity(city);
    }

    /**
     * url: api/city
     *
     * @param principal
     * @param city
     * @return
     * @throws SQLException
     */
    @PutMapping
    public City updateCity(final Principal principal, @Valid @RequestBody final City city) throws SQLException {
        return cityService.updateCity(city);
    }

    /**
     * url: api/city/:id
     *
     * @param principal
     * @param id
     * @return
     * @throws SQLException
     */
    @DeleteMapping("{id}")
    public Long deleteCity(final Principal principal, @PathVariable final Long id) throws SQLException {
        return cityService.deleteCity(id);
    }

}
