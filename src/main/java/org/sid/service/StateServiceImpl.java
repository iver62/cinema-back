package org.sid.service;

import org.sid.domain.State;
import org.sid.repository.StateRepository;
import org.sid.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StateServiceImpl implements StateService {

//    private StateRepository stateRepository;
//
//    @Autowired
//    public StateServiceImpl(StateRepository stateRepository) {
//        this.stateRepository = stateRepository;
//    }
//
//    @Override
//    public State getState(final Long id) {
//        return stateRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Page<State> getStates(String keyword, Pageable pageable) {
//        return stateRepository.findByName(keyword, pageable);
//    }
//
//    @Override
//    public Page<State> getStatesByCountry(Long id, String keyword, Pageable pageable) {
//        return stateRepository.findByCountry(id, keyword, pageable);
//    }
//
//    @Override
//    public State getStateByName(final String name) {
//        return stateRepository.findByName(name);
//    }
//
//    @Override
//    public State createState(final State state) {
//        Date date = new Date();
//        state.setLabel(Utils.capitalizeFirstLetter(state.getLabel()));
//        state.setCreationDate(date);
//        state.setLastUpdate(date);
//        return stateRepository.save(state);
//    }
//
//    @Override
//    public State updateState(final Long id, final State state) {
//        state.setId(id);
//        state.setLabel(Utils.capitalizeFirstLetter(state.getLabel()));
//        state.setLastUpdate(new Date());
//        return stateRepository.save(state);
//    }
//
//    @Override
//    public void deleteState(final Long id) {
//        stateRepository.deleteById(id);
//    }
}
