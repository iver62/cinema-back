package org.sid.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import org.sid.filters.QueryParameters;

import java.sql.SQLException;

public abstract class AbstractMapper {

    private ObjectMapper mapper;

    public AbstractMapper() {
        this.mapper = new ObjectMapper();
    }

    public abstract String getOneQuery();

    public abstract String getAllQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract String getCountQuery();

    public Object[] getOneQueryParameters(Long id) {
        return new Object[]{id};
    }

    public Object[] getAllQueryParameters(QueryParameters queryParameters) throws JsonProcessingException, SQLException {
        PGobject jsonFilters = null;
        if (queryParameters.getFilters() != null) {
            jsonFilters = new PGobject();
            jsonFilters.setType("json");
            jsonFilters.setValue(mapper.writeValueAsString(queryParameters.getFilters()));
        }
        PGobject jsonSort = new PGobject();
        jsonSort.setType("json");
        jsonSort.setValue(mapper.writeValueAsString(queryParameters.getSort()));
        return new Object[]{
                jsonFilters,
                jsonSort,
                queryParameters.getFrom(),
                queryParameters.getSize()
        };
    }

    public Object[] getDeleteQueryParameters(Long id) {
        return new Object[]{id};
    }

    public Object[] getCountQueryParameters(QueryParameters queryParameters) throws JsonProcessingException, SQLException {
        PGobject jsonFilters = null;
        if (queryParameters.getFilters() != null) {
            jsonFilters = new PGobject();
            jsonFilters.setType("json");
            jsonFilters.setValue(mapper.writeValueAsString(queryParameters.getFilters()));
        }
        return new Object[]{jsonFilters};
    }

}
