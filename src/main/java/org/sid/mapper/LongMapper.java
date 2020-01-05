package org.sid.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LongMapper implements RowMapper<Long> {

    @Override
    public Long mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return resultSet.getLong(1);
    }
}
