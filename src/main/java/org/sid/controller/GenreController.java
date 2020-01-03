package org.sid.controller;

import org.sid.domain.entities.Genre;
import org.sid.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "api/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getGenre(@PathVariable Long id) {
        HttpStatus httpStatus;
        Object entity;

        try {
            entity = genreRepository.findById(id);
            httpStatus = entity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        } catch (Exception e) {
            entity = "Erreur serveur";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(entity);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getGenres() {
        HttpStatus httpStatus;
        Object entity;

        try {
            entity = genreRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
            httpStatus = entity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        } catch (Exception e) {
            entity = "Erreur serveur";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(entity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody Genre genre) {
        HttpStatus httpStatus;
        Object entity;

        try {
            if (genreRepository.findByName(genre.getName()) != null) {
                entity = "Ce genre existe déjà";
                httpStatus = HttpStatus.CONFLICT;
            } else {
                genre.setLastUpdate(new Date());
                entity = genreRepository.save(genre);
                httpStatus = HttpStatus.OK;
            }
        } catch (Exception e) {
            entity = "Erreur serveur";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Genre genre) {
        HttpStatus httpStatus;
        Object entity = null;

        try {
            if (genreRepository.findById(id) == null) {
                httpStatus = HttpStatus.NO_CONTENT;
            } else {
                if (genreRepository.findByName(genre.getName()) != null) {
                    entity = "Ce genre existe déjà";
                    httpStatus = HttpStatus.CONFLICT;
                } else {
                    genre.setId(id);
                    genre.setLastUpdate(new Date());
                    entity = genreRepository.save(genre);
                    httpStatus = HttpStatus.OK;
                }
            }
        } catch (Exception e) {
            entity = "Erreur serveur";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        HttpStatus httpStatus;
        Object entity = null;

        try {
            if (genreRepository.findById(id) != null) {
                genreRepository.deleteById(id);
                entity = "Genre supprimé avec succés";
                httpStatus = HttpStatus.OK;
            } else {
                httpStatus = HttpStatus.NO_CONTENT;
            }
        } catch (Exception e) {
            entity = "Erreur serveur";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(entity);
    }

}
