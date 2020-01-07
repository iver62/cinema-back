package org.sid.controller;

import org.sid.domain.State;
import org.sid.domain.dto.StatesDTO;
import org.sid.filters.RequestOptions;
import org.sid.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "api/state")
public class StateController {

    private StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    /**
     * url: api/state/:id
     *
     * @param principal
     * @param id
     * @return
     * @throws SQLException
     */
    @GetMapping("{id}")
    public State getState(final Principal principal, @PathVariable final Long id) throws SQLException {
        return stateService.getState(id);
    }

    /**
     * url: api/state/all
     *
     * @param principal
     * @param requestOptions
     * @return
     * @throws SQLException
     */
    @PostMapping("/all")
    public StatesDTO getStates(final Principal principal, @RequestBody final RequestOptions requestOptions) throws SQLException {
        StatesDTO statesDTO = new StatesDTO();
        if (requestOptions.isWithCount()) {
            statesDTO.setCount(stateService.countStates(requestOptions.getQueryParameters()));
        }
        statesDTO.setStates(stateService.getStates(requestOptions.getQueryParameters()));
        return statesDTO;
    }

    /**
     * url: api/state/search
     *
     * @param principal
     * @param state
     * @return
     * @throws SQLException
     */
    @PostMapping("search")
    public boolean getStateByLabel(final Principal principal, @RequestBody @Valid State state) throws SQLException {
        return stateService.getStateByLabel(state);
    }

    /**
     * url: api/state
     *
     * @param principal
     * @param state
     * @return
     * @throws SQLException
     */
    @PostMapping
    public State createState(final Principal principal, @Valid @RequestBody final State state) throws SQLException {
        return stateService.createState(state);
    }

    /**
     * url: api/state
     *
     * @param principal
     * @param state
     * @return
     * @throws SQLException
     */
    @PutMapping
    public State updateState(final Principal principal, @Valid @RequestBody final State state) throws SQLException {
        return stateService.updateState(state);
    }

    /**
     * url: api/country/:id
     *
     * @param principal
     * @param id
     * @return
     * @throws SQLException
     */
    @DeleteMapping("{id}")
    public Long deleteState(final Principal principal, @PathVariable final Long id) throws SQLException {
        return stateService.deleteState(id);
    }

}