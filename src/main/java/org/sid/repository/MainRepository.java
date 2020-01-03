package org.sid.repository;

import org.sid.filters.QueryParameters;

import java.sql.SQLException;

public interface MainRepository {

    Long count(QueryParameters queryParameters) throws SQLException;

    Long deleteById(Long id) throws SQLException;
}
