package org.sid.mapper;

import org.sid.domain.State;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StateMapper extends AbstractMapper implements RowMapper<State> {

    private static final String ID = "id_state";
    private static final String LABEL = "label";
    private static final String COUNTRY_ID = "id_country";
    private static final String COUNTRY_LABEL = "country_label";
    private static final String CREATION_DATE = "creation_date";
    private static final String LAST_UPDATE = "last_update";
    private static final String FLAG = "flag";

    private static final String GET_ONE_QUERY = "SELECT * FROM public.get_state(?);";
    private static final String GET_ALL_QUERY = "SELECT * FROM public.get_states(?,?,?,?);";
    private static final String SEARCH_BY_LABEL_QUERY = "SELECT * FROM public.search_state_label_in_country(?,?,?);";
    private static final String CREATE_QUERY = "SELECT * FROM public.create_state(?,?,?,?,?);";
    private static final String UPDATE_QUERY = "SELECT * FROM public.update_state(?,?,?,?,?);";
    private static final String DELETE_QUERY = "SELECT * FROM public.delete_state(?);";
    private static final String COUNT_QUERY = "SELECT * FROM public.count_states(?);";

    public StateMapper() {
        super();
    }

    @Override
    public String getOneQuery() {
        return null;
    }

    @Override
    public String getAllQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getCountQuery() {
        return null;
    }

    @Override
    public State mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
