package org.sid.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sid.domain.City;
import org.sid.filters.QueryParameters;
import org.sid.mapper.BooleanMapper;
import org.sid.mapper.CityMapper;
import org.sid.mapper.LongMapper;
import org.sid.utils.ClientMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private static final Logger logger = LogManager.getLogger(CityRepositoryImpl.class);

    private JdbcTemplate jdbcTemplate;
    private CityMapper mapper;

    @Autowired
    public CityRepositoryImpl(JdbcTemplate jdbcTemplate, CityMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public City findById(Long id) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getOneQuery(),
                    mapper.getOneQueryParameters(id),
                    mapper
            );
        } catch (Exception e) {
            logger.error("findById() - An error occured while getting city .. ", e);
            throw new SQLException(ClientMessages.CITY_FIND_BY_ID.toString());
        }
    }

    @Override
    public List<City> findAll(QueryParameters queryParameters) throws SQLException {
        try {
            return jdbcTemplate.query(
                    mapper.getAllQuery(),
                    mapper.getAllQueryParameters(queryParameters),
                    mapper
            );
        } catch (Exception e) {
            logger.error("findAll() - An error occured while getting cities .. ", e);
            throw new SQLException(ClientMessages.CITY_FIND_ALL.toString());
        }
    }

    @Override
    public boolean findByLabel(City city) throws SQLException {
        Boolean found;
        try {
            found = jdbcTemplate.queryForObject(
                    mapper.getSearchByLabelQuery(),
                    mapper.getSearchByLabelQueryParameters(city),
                    new BooleanMapper()
            );
            return found;
        } catch (Exception e) {
            logger.error("findByLabel() - An error occured while searching city .. ", e);
            throw new SQLException(ClientMessages.CITY_SEARCH_BY_LABEL.toString());
        }
    }

    @Override
    public City create(City city) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getCreateQuery(),
                    mapper.getCreateQueryParameters(city),
                    mapper
            );
        } catch (Exception e) {
            logger.error("create() - An error occured while creating city .. ", e);
            throw new SQLException(ClientMessages.CITY_CREATE.toString());
        }
    }

    @Override
    public City update(City city) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getUpdateQuery(),
                    mapper.getUpdateQueryParameters(city),
                    mapper
            );
        } catch (Exception e) {
            logger.error("update() - An error occured while updating city .. ", e);
            throw new SQLException(ClientMessages.CITY_UPDATE.toString());
        }
    }

    @Override
    public Long count(QueryParameters queryParameters) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getCountQuery(),
                    mapper.getCountQueryParameters(queryParameters),
                    new LongMapper()
            );
        } catch (Exception e) {
            logger.error("count() - An error occured while counting cities .. ", e);
            throw new SQLException(ClientMessages.CITY_COUNT.toString());
        }
    }

    @Override
    public Long deleteById(Long id) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getDeleteQuery(),
                    mapper.getDeleteQueryParameters(id),
                    new LongMapper()
            );
        } catch (Exception e) {
            logger.error("deleteById() - An error occured while deleting city .. ", e);
            throw new SQLException(ClientMessages.CITY_DELETE_BY_ID.toString());
        }
    }
}
