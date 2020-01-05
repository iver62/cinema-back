package org.sid.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sid.domain.State;
import org.sid.filters.QueryParameters;
import org.sid.mapper.BooleanMapper;
import org.sid.mapper.LongMapper;
import org.sid.mapper.StateMapper;
import org.sid.utils.ClientMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

    private static final Logger logger = LogManager.getLogger(StateRepositoryImpl.class);

    private JdbcTemplate jdbcTemplate;
    private StateMapper mapper;

    @Autowired
    public StateRepositoryImpl(JdbcTemplate jdbcTemplate, StateMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public State findById(Long id) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getOneQuery(),
                    mapper.getOneQueryParameters(id),
                    mapper
            );
        } catch (Exception e) {
            logger.error("findById() - An error occured while getting state .. ", e);
            throw new SQLException(ClientMessages.STATE_FIND_BY_ID.toString());
        }
    }

    @Override
    public List<State> findAll(QueryParameters queryParameters) throws SQLException {
        try {
            return jdbcTemplate.query(
                    mapper.getAllQuery(),
                    mapper.getAllQueryParameters(queryParameters),
                    mapper
            );
        } catch (Exception e) {
            logger.error("findAll() - An error occured while getting states .. ", e);
            throw new SQLException(ClientMessages.STATE_FIND_ALL.toString());
        }
    }

    @Override
    public boolean findByLabel(State state) throws SQLException {
        Boolean found;
        try {
            found = jdbcTemplate.queryForObject(
                    mapper.getSearchByLabelQuery(),
                    mapper.getSearchByLabelQueryParameters(state),
                    new BooleanMapper()
            );
            return found;
        } catch (Exception e) {
            logger.error("findByLabel() - An error occured while searching states .. ", e);
            throw new SQLException(ClientMessages.STATE_SEARCH_BY_LABEL.toString());
        }
    }

    @Override
    public State create(State state) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getCreateQuery(),
                    mapper.getCreateQueryParameters(state),
                    mapper
            );
        } catch (Exception e) {
            logger.error("create() - An error occured while creating state .. ", e);
            throw new SQLException(ClientMessages.STATE_CREATE.toString());
        }
    }

    @Override
    public State update(State state) throws SQLException {
        try {
            return jdbcTemplate.queryForObject(
                    mapper.getUpdateQuery(),
                    mapper.getUpdateQueryParameters(state),
                    mapper
            );
        } catch (Exception e) {
            logger.error("update() - An error occured while updating state .. ", e);
            throw new SQLException(ClientMessages.STATE_UPDATE.toString());
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
            logger.error("count() - An error occured while counting states .. ", e);
            throw new SQLException(ClientMessages.STATE_COUNT.toString());
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
            logger.error("deleteById() - An error occured while deleting state .. ", e);
            throw new SQLException(ClientMessages.STATE_DELETE_BY_ID.toString());
        }
    }
}
