package org.sid.service;

import org.sid.domain.State;
import org.sid.filters.QueryParameters;

import java.sql.SQLException;
import java.util.List;

public interface StateService {

    State getState(Long id) throws SQLException;

    List<State> getStates(QueryParameters queryParameters) throws SQLException;

    boolean getStateByLabel(State state) throws SQLException;

    State createState(State state) throws SQLException;

    State updateState(State state) throws SQLException;

    Long deleteState(Long id) throws SQLException;

    Long countStates(QueryParameters queryParameters) throws SQLException;


}
