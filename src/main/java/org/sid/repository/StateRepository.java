package org.sid.repository;

import org.sid.domain.State;
import org.sid.filters.QueryParameters;

import java.sql.SQLException;
import java.util.List;

public interface StateRepository extends MainRepository {

    State findById(Long id) throws SQLException;

    List<State> findAll(QueryParameters queryParameters) throws SQLException;

    boolean findByLabel(State state) throws SQLException;

    State create(State state) throws SQLException;

    State update(State state) throws SQLException;

}
