package org.sid.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanMapper implements RowMapper<Boolean> {

    @Override
    public Boolean mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return resultSet.getBoolean(1);
    }
}
