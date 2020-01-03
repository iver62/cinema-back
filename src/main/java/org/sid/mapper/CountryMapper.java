package org.sid.mapper;

import org.sid.domain.Country;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CountryMapper extends AbstractMapper implements RowMapper<Country> {

    private static final String ID = "id_country";
    private static final String LABEL = "label";
    private static final String CREATION_DATE = "creation_date";
    private static final String LAST_UPDATE = "last_update";
    private static final String FLAG = "flag";

    private static final String GET_ONE_QUERY = "SELECT * FROM public.get_country(?);";
    private static final String GET_ALL_QUERY = "SELECT * FROM public.get_countries(?,?,?,?);";
    private static final String SEARCH_BY_LABEL_QUERY = "SELECT * FROM public.search_countries_by_label(?,?);";
    private static final String CREATE_QUERY = "SELECT * FROM public.create_country(?,?,?,?);";
    private static final String UPDATE_QUERY = "SELECT * FROM public.update_country(?,?,?,?);";
    private static final String DELETE_QUERY = "SELECT * FROM public.delete_country(?);";
    private static final String COUNT_QUERY = "SELECT * FROM public.count_countries(?);";

    public CountryMapper() {
        super();
    }

    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        return Country.builder()
                .id(resultSet.getLong(ID))
                .label(resultSet.getString(LABEL))
                .creationDate(resultSet.getTimestamp(CREATION_DATE))
                .lastUpdate(resultSet.getTimestamp(LAST_UPDATE))
                .flag(resultSet.getString(FLAG))
                .build();
    }

    @Override
    public String getOneQuery() {
        return GET_ONE_QUERY;
    }

    @Override
    public String getAllQuery() {
        return GET_ALL_QUERY;
    }

    public String getSearchByLabelQuery() {
        return SEARCH_BY_LABEL_QUERY;
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

    public Object[] getSearchByLabelQueryParameters(Country country) {
        return new Object[]{
                country.getLabel(),
                country.getId()
        };
    }

    public Object[] getCreateQueryParameters(Country country) {
        return new Object[]{
                country.getLabel(),
                country.getCreationDate(),
                country.getLastUpdate(),
                country.getFlag()
        };
    }

    public Object[] getUpdateQueryParameters(Country country) {
        return new Object[]{
                country.getId(),
                country.getLabel(),
                country.getLastUpdate(),
                country.getFlag()
        };
    }
}
