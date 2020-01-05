package org.sid.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sid.domain.Country;
import org.sid.filters.QueryParameters;
import org.sid.mapper.BooleanMapper;
import org.sid.mapper.CountryMapper;
import org.sid.mapper.LongMapper;
import org.sid.utils.ClientMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private static final Logger logger = LogManager.getLogger(CountryRepositoryImpl.class);

    private JdbcTemplate jdbcTemplate;
    private CountryMapper mapper;

    @Autowired
    public CountryRepositoryImpl(JdbcTemplate jdbcTemplate, CountryMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public Country findById(final Long id) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getOneQuery(),
                    mapper.getOneQueryParameters(id),
                    mapper
            );
        } catch (Exception e) {
            logger.error("findById() - An error occured while getting country .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_FIND_BY_ID.toString());
        }
    }

    @Override
    public List<Country> findAll(final QueryParameters queryParameters) throws SQLException {
        try {
            return jdbcTemplate.query(
                    mapper.getAllQuery(),
                    mapper.getAllQueryParameters(queryParameters),
                    mapper
            );
        } catch (Exception e) {
            logger.error("findAll() - An error occured while getting countries .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_FIND_ALL.toString());
        }
    }

    @Override
    public boolean findByLabel(final Country country) throws SQLException {
        Boolean found;
        try {
            found = jdbcTemplate.queryForObject(
                    mapper.getSearchByLabelQuery(),
                    mapper.getSearchByLabelQueryParameters(country),
                    new BooleanMapper()
            );
            return found;
        } catch (Exception e) {
            logger.error("findByLabel() - An error occured while searching country .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_SEARCH_BY_LABEL.toString());
        }
    }

    @Override
    public Country create(final Country country) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getCreateQuery(),
                    mapper.getCreateQueryParameters(country),
                    mapper
            );
        } catch (Exception e) {
            logger.error("create() - An error occured while creating country .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_CREATE.toString());
        }
    }

    @Override
    public Country update(final Country country) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getUpdateQuery(),
                    mapper.getUpdateQueryParameters(country),
                    mapper
            );
        } catch (Exception e) {
            logger.error("update() - An error occured while updating country .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_UPDATE.toString());
        }
    }

    @Override
    public Long deleteById(final Long id) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getDeleteQuery(),
                    mapper.getDeleteQueryParameters(id),
                    new LongMapper()
            );
        } catch (Exception e) {
            logger.error("deleteById() - An error occured while deleting country .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_DELETE_BY_ID.toString());
        }
    }

    @Override
    public Long count(final QueryParameters queryParameters) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getCountQuery(),
                    mapper.getCountQueryParameters(queryParameters),
                    new LongMapper()
            );
        } catch (Exception e) {
            logger.error("count() - An error occured while counting countries .. ", e);
            throw new SQLException(ClientMessages.COUNTRY_COUNT.toString());
        }
    }
}
