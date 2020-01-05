package org.sid.service;

import org.sid.domain.State;
import org.sid.filters.QueryParameters;
import org.sid.repository.StateRepository;
import org.sid.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @Override
    public State getState(final Long id) throws SQLException {
        return stateRepository.findById(id);
    }

    @Override
    public List<State> getStates(final QueryParameters queryParameters) throws SQLException {
        return stateRepository.findAll(queryParameters);
    }

    @Override
    public boolean getStateByLabel(final State state) throws SQLException {
        return stateRepository.findByLabel(state);
    }

    @Override
    public State createState(final State state) throws SQLException {
        state.setLabel(Utils.capitalizeFirstLetter(state.getLabel()));
        return stateRepository.create(state);
    }

    @Override
    public State updateState(final State state) throws SQLException {
        state.setLabel(Utils.capitalizeFirstLetter(state.getLabel()));
        return stateRepository.update(state);
    }

    @Override
    public Long deleteState(final Long id) throws SQLException {
        return stateRepository.deleteById(id);
    }

    @Override
    public Long countStates(final QueryParameters queryParameters) throws SQLException {
        return stateRepository.count(queryParameters);
    }

}
