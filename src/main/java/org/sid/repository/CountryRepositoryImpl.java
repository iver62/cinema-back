package org.sid.repository;

import org.sid.domain.Country;
import org.sid.filters.QueryParameters;
import org.sid.mapper.BooleanMapper;
import org.sid.mapper.CountryMapper;
import org.sid.mapper.LongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private JdbcTemplate jdbcTemplate;
    private CountryMapper mapper;

    private static final String FIND_BY_ID_CLIENT_MESSAGE = "Erreur lors de la récupération du pays";
    private static final String FIND_ALL_CLIENT_MESSAGE = "Erreur lors de la récupération de la liste des pays";
    private static final String SEARCH_BY_LABEL_CLIENT_MESSAGE = "Erreur lors de la recherche des pays";
    private static final String CREATE_CLIENT_MESSAGE = "Erreur lors de la création du pays";
    private static final String UPDATE_CLIENT_MESSAGE = "Erreur lors de la modification du pays";
    private static final String DELETE_BY_ID_CLIENT_MESSAGE = "Erreur lors de la suppression du pays";
    private static final String COUNT_CLIENT_MESSAGE = "Erreur lors du comptage des pays";

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
            throw new SQLException(FIND_BY_ID_CLIENT_MESSAGE);
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
            throw new SQLException(FIND_ALL_CLIENT_MESSAGE);
        }
    }

    @Override
    public boolean findByLabel(final Country country) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getSearchByLabelQuery(),
                    mapper.getSearchByLabelQueryParameters(country),
                    new BooleanMapper()
            );
        } catch (Exception e) {
            throw new SQLException(SEARCH_BY_LABEL_CLIENT_MESSAGE);
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
            throw new SQLException(CREATE_CLIENT_MESSAGE);
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
            throw new SQLException(UPDATE_CLIENT_MESSAGE);
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
            throw new SQLException(DELETE_BY_ID_CLIENT_MESSAGE);
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
            throw new SQLException(COUNT_CLIENT_MESSAGE);
        }
    }
}
