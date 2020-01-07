package org.sid.mapper;

import org.sid.domain.City;
import org.sid.domain.Country;
import org.sid.domain.State;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CityMapper extends AbstractMapper implements RowMapper<City> {

    private static final String ID = "id_city";
    private static final String LABEL = "label";
    private static final String STATE_ID = "state_id";
    private static final String STATE_LABEL = "state_label";
    private static final String COUNTRY_ID = "country_id";
    private static final String COUNTRY_LABEL = "country_label";
    private static final String CREATION_DATE = "creation_date";
    private static final String LAST_UPDATE = "last_update";

    private static final String GET_ONE_QUERY = "SELECT * FROM public.get_city(?);";
    private static final String GET_ALL_QUERY = "SELECT * FROM public.get_cities(?,?,?,?);";
    private static final String SEARCH_BY_LABEL_QUERY = "SELECT * FROM public.search_city_by_label(?,?,?,?);";
    private static final String CREATE_QUERY = "SELECT * FROM public.create_city(?,?,?,?,?);";
    private static final String UPDATE_QUERY = "SELECT * FROM public.update_city(?,?,?,?,?);";
    private static final String DELETE_QUERY = "SELECT * FROM public.delete_city(?);";
    private static final String COUNT_QUERY = "SELECT * FROM public.count_cities(?);";

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

    public Object[] getSearchByLabelQueryParameters(City city) {
        return new Object[]{
                city.getState().getId(),
                city.getCountry().getId(),
                city.getLabel(),
                city.getId()
        };
    }

    public Object[] getCreateQueryParameters(City city) {
        return new Object[]{
                city.getLabel(),
                city.getState().getId(),
                city.getCountry().getId(),
                city.getCreationDate(),
                city.getLastUpdate()
        };
    }

    public Object[] getUpdateQueryParameters(City city) {
        return new Object[]{
                city.getId(),
                city.getLabel(),
                city.getState().getId(),
                city.getCountry().getId(),
                city.getLastUpdate()
        };
    }

    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        return City.builder()
                .id(resultSet.getLong(ID))
                .label(resultSet.getString(LABEL))
                .state(State.builder().id(resultSet.getLong(STATE_ID)).label(resultSet.getString(STATE_LABEL)).build())
                .country(Country.builder().id(resultSet.getLong(COUNTRY_ID)).label(resultSet.getString(COUNTRY_LABEL)).build())
                .creationDate(resultSet.getTimestamp(CREATION_DATE))
                .lastUpdate(resultSet.getTimestamp(LAST_UPDATE))
                .build();
    }
}
