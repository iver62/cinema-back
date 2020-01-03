//package org.sid.controller;
//
//import org.modelmapper.ModelMapper;
//import org.sid.service.StateService;
//import org.sid.domain.dto.StateDTO;
//import org.sid.domain.entities.State;
//import org.sid.utils.Utils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping(value = "api/state")
//public class StateController {
//
//    private StateService stateService;
//    private static final String SERVER_ERROR = "Erreur serveur";
//
//    @Autowired
//    public StateController(StateService stateService) {
//        this.stateService = stateService;
//    }
//
//    /**
//     * url: api/state/:id
//     *
//     * @param id
//     * @return
//     */
//    @GetMapping(value = "{id}")
//    public ResponseEntity<Object> getState(@PathVariable final Long id) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            entity = stateService.getState(id);
//            httpStatus = entity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
//        } catch (Exception e) {
//            entity = SERVER_ERROR;
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    /**
//     * url: api/state
//     *
//     * @param keyword
//     * @param page
//     * @param size
//     * @param column
//     * @param direction
//     * @return
//     */
//    @GetMapping()
//    public ResponseEntity<Object> getStates(
//            @RequestParam(value = "keyword", defaultValue = "") final String keyword,
//            @RequestParam(value = "page", defaultValue = "0") final int page,
//            @RequestParam(value = "size", defaultValue = "20") final int size,
//            @RequestParam(value = "property", defaultValue = "name") final String column,
//            @RequestParam(value = "direction", defaultValue = "asc") final String direction
//    ) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            int newSize;
//            Sort.Direction dir = direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
//            newSize = size == 0 ? Integer.MAX_VALUE : size;
//            entity = stateService.getStates("%" + keyword + "%", PageRequest.of(page, newSize, new Sort(dir, column)));
//            httpStatus = entity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
//        } catch (Exception e) {
//            entity = SERVER_ERROR;
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    /**
//     * url: api/state
//     *
//     * @param stateDTO
//     * @return
//     */
//    @PostMapping()
//    public ResponseEntity<Object> createState(@Valid @RequestBody final StateDTO stateDTO) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            if (stateService.getStateByName(Utils.capitalizeFirstLetter(stateDTO.getName())) != null) {
//                entity = "Cette région existe déjà";
//                httpStatus = HttpStatus.CONFLICT;
//            } else {
//                entity = stateService.createState(convertToEntity(stateDTO));
//                httpStatus = HttpStatus.OK;
//            }
//        } catch (Exception e) {
//            entity = SERVER_ERROR;
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    /**
//     * url: api/state/:id
//     *
//     * @param id
//     * @param state
//     * @return
//     */
//    @PutMapping(value = "{id}")
//    public ResponseEntity<Object> updateState(@PathVariable final Long id, @Valid @RequestBody final State state) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            if (stateService.getStateByName(Utils.capitalizeFirstLetter(state.getName())) != null) {
//                entity = "Cette région existe déjà";
//                httpStatus = HttpStatus.CONFLICT;
//            } else {
//                entity = stateService.updateState(id, state);
//                httpStatus = HttpStatus.OK;
//            }
//        } catch (Exception e) {
//            entity = SERVER_ERROR;
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    /**
//     * url: api/state/:id
//     *
//     * @param id
//     * @return
//     */
//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<Object> deleteState(@PathVariable final Long id) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            stateService.deleteState(id);
//            entity = "Région supprimée avec succés";
//            httpStatus = HttpStatus.OK;
//        } catch (Exception e) {
//            entity = "Ressource introuvable";
//            httpStatus = HttpStatus.NOT_FOUND;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//}