package org.sid.integration.repository;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sid.domain.Country;
import org.sid.repository.CountryRepository;
import org.sid.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@IfProfileValue(name = "spring.profiles.active", value = "integration-tests")
@WithMockUser()
public class CountryRepositoryIntegrationTest extends IntegrationTest {

    private static final Logger logger = LogManager.getLogger(CountryRepositoryIntegrationTest.class);
    private List<Country> countries;
    private Country country;

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryService countryService;

    @Before
    public void init() {
        Assert.assertNotNull(countryRepository);
    }

    @SneakyThrows
    @Test
    public void test1FindAllCountriesTest() {
        logTestName("test1FindAllCountriesTest");
        countries = countryRepository.findAll(getQueryParameters(false));
        Assert.assertNotNull(countries);
        logList(countries);
        getLogger().info("test1FindAllCountriesTest : SUCCESS");
    }

    @SneakyThrows
    @Test
    public void test2FindPaginatedCountriesTest() {
        logTestName("test2FindPaginatedCountriesTest");
        countries = countryRepository.findAll(getQueryParameters(true));
        Assert.assertNotNull(countries);
        Assert.assertTrue(countries.size() <= (size - from));
        logList(countries);
        getLogger().info("test2FindPaginatedCountriesTest : SUCCESS");
    }

    @SneakyThrows
    @Test
    public void test3CreateCountryTest() {
        logTestName("test3CreateCountryTest");
        this.country.setLabel(RandomStringUtils.randomAlphabetic(10));
        this.country.setFlag(RandomStringUtils.randomAlphabetic(10));
        Country country = countryRepository.create(this.country);
        Assert.assertNotNull(country);
        Assert.assertNotNull(country.getId());
        this.country.setId(country.getId());
        getLogger().info("test3CreateCountryTest : SUCCESS");
    }

    @SneakyThrows
    @Test
    public void tes4GetCountryTest() {
        logTestName("tes4GetCountryTest");
        Country country = countryRepository.findById(this.country.getId());
        Assert.assertNotNull(country);
        getLogger().info("tes4GetCountryTest : SUCCESS");
    }

    @SneakyThrows
    @Test
    public void test5FindCountryByLabel() {
        logTestName("test5FindCountryByLabel");
        Country c = Country.builder().label(country.getLabel()).build();
        boolean r = countryRepository.findByLabel(country);
        Assert.assertTrue(r);
        c.setId(country.getId());
        r = countryRepository.findByLabel(country);
        Assert.assertFalse(r);
        getLogger().info("test5FindCountryByLabel : SUCCESS");
    }

    @SneakyThrows
    @Test
    public void test6UpdateCountry() {
        logTestName("test6UpdateCountry");
        country.setLabel("updated label");
        country.setFlag("updated flag");
        country = countryRepository.update(country);
        Assert.assertNotNull(country);
        Assert.assertEquals("updated label", country.getLabel());
        Assert.assertEquals("updated flag", country.getFlag());
        getLogger().info("test6UpdateCountry : SUCCESS");
    }

    @SneakyThrows
    @Test
    public void test7DeleteCountry() {
        logTestName("test7DeleteCountry");
        Long result = countryRepository.deleteById(country.getId());
        Assert.assertTrue(result > 0);
        getLogger().info("test7DeleteCountry : SUCCESS");
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

}
