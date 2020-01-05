package org.sid.mapper;

import org.sid.domain.Country;
import org.sid.domain.State;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StateMapper extends AbstractMapper implements RowMapper<State> {

    private static final String ID = "id_state";
    private static final String LABEL = "label";
    private static final String COUNTRY_ID = "country_id";
    private static final String COUNTRY_LABEL = "country_label";
    private static final String CREATION_DATE = "creation_date";
    private static final String LAST_UPDATE = "last_update";
    private static final String FLAG = "flag";

    private static final String GET_ONE_QUERY = "SELECT * FROM public.get_state(?);";
    private static final String GET_ALL_QUERY = "SELECT * FROM public.get_states(?,?,?,?);";
    private static final String SEARCH_BY_LABEL_QUERY = "SELECT * FROM public.search_state_by_label(?,?,?);";
    private static final String CREATE_QUERY = "SELECT * FROM public.create_state(?,?,?,?,?);";
    private static final String UPDATE_QUERY = "SELECT * FROM public.update_state(?,?,?,?,?);";
    private static final String DELETE_QUERY = "SELECT * FROM public.delete_state(?);";
    private static final String COUNT_QUERY = "SELECT * FROM public.count_states(?);";

    public StateMapper() {
        super();
    }

    @Override
    public String getOneQuery() {
        return GET_ONE_QUERY;
    }

    @Override
    public String getAllQuery() {
        return GET_ALL_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_QUERY;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUERY;
    }

    @Override
    public String getCountQuery() {
        return COUNT_QUERY;
    }

    public String getSearchByLabelQuery() {
        return SEARCH_BY_LABEL_QUERY;
    }

    public Object[] getSearchByLabelQueryParameters(State state) {
        return new Object[]{
                state.getCountry().getId(),
                state.getLabel(),
                state.getId()
        };
    }

    public Object[] getCreateQueryParameters(State state) {
        return new Object[]{
                state.getLabel(),
                state.getCountry().getId(),
                state.getCreationDate(),
                state.getLastUpdate(),
                state.getFlag()
        };
    }

    public Object[] getUpdateQueryParameters(State state) {
        return new Object[]{
                state.getId(),
                state.getLabel(),
                state.getCountry().getId(),
                state.getLastUpdate(),
                state.getFlag()
        };
    }

    @Override
    public State mapRow(ResultSet resultSet, int i) throws SQLException {
        return State.builder()
                .id(resultSet.getLong(ID))
                .label(resultSet.getString(LABEL))
                .country(Country.builder().id(resultSet.getLong(COUNTRY_ID)).label(resultSet.getString(COUNTRY_LABEL)).build())
                .creationDate(resultSet.getTimestamp(CREATION_DATE))
                .lastUpdate(resultSet.getTimestamp(LAST_UPDATE))
                .flag(resultSet.getString(FLAG))
                .build();
    }
}
