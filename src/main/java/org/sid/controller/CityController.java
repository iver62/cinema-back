//package org.sid.controller;
//
//import org.sid.domain.dto.CityDTO;
//import org.sid.domain.entities.City;
//import org.sid.service.CityService;
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
//@RequestMapping(value = "api/city")
//public class CityController {
//
//    private CityService cityService;
//    private static final String SERVER_ERROR = "Erreur serveur";
//
//    @Autowired
//    public CityController(CityService cityService) {
//        this.cityService = cityService;
//    }
//
//    /**
//     * url: api/city/:id
//     *
//     * @param id
//     * @return
//     */
//    @GetMapping(value = "{id}")
//    public ResponseEntity<Object> getCity(@PathVariable final Long id) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            entity = cityService.getCity(id);
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
//     * url: api/city
//     *
//     * @param keyword
//     * @param page
//     * @param size
//     * @param column
//     * @param direction
//     * @return
//     */
//    @GetMapping()
//    public ResponseEntity<Object> getCities(
//            @RequestParam(value = "keyword", defaultValue = "") final String keyword,
//            @RequestParam(value = "page", defaultValue = "0") final int page,
//            @RequestParam(value = "size", defaultValue = "20") final int size,
//            @RequestParam(value = "property", defaultValue = "name") final String column,
//            @RequestParam(value = "direction", defaultValue = "asc") final String direction) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            int newSize;
//            Sort.Direction dir = direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
//            newSize = size == 0 ? Integer.MAX_VALUE : size;
//            entity = cityService.getCities("%" + keyword + "%", PageRequest.of(page, newSize, new Sort(dir, column)));
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
//     * url: api/city
//     *
//     * @param cityDTO
//     * @return
//     */
//    @PostMapping()
//    public ResponseEntity<Object> CreateCity(@Valid @RequestBody final CityDTO cityDTO) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            if (cityService.getCityByName(cityDTO.getName()) != null) {
//                entity = "Cette ville existe déjà";
//                httpStatus = HttpStatus.CONFLICT;
//            } else {
//                entity = cityService.createCity(convertToEntity(cityDTO));
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
//     * url: api/city/:id
//     *
//     * @param id
//     * @param cityDTO
//     * @return
//     */
//    @PutMapping(value = "{id}")
//    public ResponseEntity<Object> updateCity(@PathVariable final Long id, @Valid @RequestBody final CityDTO cityDTO) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            if (cityService.getCityByName(cityDTO.getName()) != null) {
//                entity = "Cette ville existe déjà";
//                httpStatus = HttpStatus.CONFLICT;
//            } else {
//                httpStatus = HttpStatus.OK;
//            }
//        } catch (Exception e) {
//            entity = "Erreur serveur";
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    /**
//     * url: api/city/:id
//     *
//     * @param id
//     * @return
//     */
//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<Object> deleteCity(@PathVariable final Long id) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            cityService.deleteCity(id);
//            entity = "Ville supprimée avec succés";
//            httpStatus = HttpStatus.ACCEPTED;
//        } catch (Exception e) {
//            entity = "Ressource introuvable";
//            httpStatus = HttpStatus.NOT_FOUND;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//}
