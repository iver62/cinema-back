//package org.sid.controller;
//
//import org.sid.domain.Person;
//import org.sid.domain.entities.Genre;
//import org.sid.domain.Movie;
//import org.sid.repository.CountryRepository;
//import org.sid.repository.GenreRepository;
//import org.sid.repository.MovieRepository;
//import org.sid.repository.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "api/movie")
//public class MovieController {
//
//    @Autowired
//    private MovieRepository movieRepository;
//    @Autowired
//    private GenreRepository genreRepository;
//    @Autowired
//    private PersonRepository personRepository;
//    @Autowired
//    private CountryRepository countryRepository;
//
//    private final Path rootLocation = Paths.get("angular/src/assets/posters");
//
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    public ResponseEntity<Object> getMovieById(@PathVariable Long id) {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            entity = movieRepository.findById(id);
//            httpStatus = entity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
//        } catch (Exception e) {
//            entity = "Erreur serveur";
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Object> getMovies() {
//        HttpStatus httpStatus;
//        Object entity;
//
//        try {
//            entity = movieRepository.findAll(new Sort(Sort.Direction.ASC, "frenchTitle"));
//            httpStatus = entity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
//        } catch (Exception e) {
//            entity = "Erreur serveur";
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
////	@RequestMapping(value="search", method=RequestMethod.GET)
////	public List<Movie> search(@RequestParam(value="keyword", defaultValue="") String keyword) {
////		return movieRepository.search("%"+keyword+"%");
////	}
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Object> save(@RequestBody Movie movie) {
//        HttpStatus httpStatus;
//        Object entity;
//        System.out.println("------------------------- " + movie);
//
//        try {
//            if (movieRepository.findByFrenchTitle(movie.getFrenchTitle()) != null) {
//                entity = "Un film possède déjà ce titre";
//                httpStatus = HttpStatus.CONFLICT;
//            } else {
//                List<Genre> genres = movie.getGenres();
//                if (genres != null) {
//                    for (int i = 0; i < genres.size(); i++) {
//                        Genre genre = genres.get(i);
//                        if (genreRepository.findByName(genre.getName()) == null) {
//                            genre.setLastUpdate(new Date());
//                            genre = genreRepository.save(genre);
//                        } else {
//                            genre = genreRepository.findByName(genre.getName());
//                            genres.set(i, genre);
//                        }
//                    }
//                }
//
//                List<Person> directors = movie.getDirectors();
//                if (directors != null) {
//                    for (int i = 0; i < directors.size(); i++) {
//                        Person director = directors.get(i);
//                        if (personRepository.findByLastnameAndFirstname(director.getLastname(), director.getFirstname()) == null) {
//                            director.setLastUpdate(new Date());
//                            director = personRepository.save(director);
//                        } else {
//                            director = personRepository.findByLastnameAndFirstname(director.getLastname(), director.getFirstname());
//                            directors.set(i, director);
//                        }
//                    }
//                }
//
//                List<Person> writers = movie.getWriters();
//                if (writers != null) {
//                    for (int i = 0; i < writers.size(); i++) {
//                        Person writer = writers.get(i);
//                        if (personRepository.findByLastnameAndFirstname(writer.getLastname(), writer.getFirstname()) == null) {
//                            writer.setLastUpdate(new Date());
//                            writer = personRepository.save(writer);
//                        } else {
//                            writer = personRepository.findByLastnameAndFirstname(writer.getLastname(), writer.getFirstname());
//                            writers.set(i, writer);
//                        }
//                    }
//                }
//
//                List<Person> actors = movie.getActors();
//                if (actors != null) {
//                    for (int i = 0; i < actors.size(); i++) {
//                        Person actor = actors.get(i);
//                        if (personRepository.findByLastnameAndFirstname(actor.getLastname(), actor.getFirstname()) == null) {
//                            actor.setLastUpdate(new Date());
//                            actor = personRepository.save(actor);
//                        } else {
//                            actor = personRepository.findByLastnameAndFirstname(actor.getLastname(), actor.getFirstname());
//                            actors.set(i, actor);
//                        }
//                    }
//                }
//
////				List <Quote> quotes = movie.getQuotes();
////				if (quotes != null) {
////					for (int i = 0; i < countries.size(); i++) {
////						Country country = countries.get(i);
////						if (countryRepository.findByName(country.getName()) == null) {
////							country.setLastUpdate(new Date());
////							country = countryRepository.save(country);
////						} else {
////							country = countryRepository.findByName(country.getName());
////							countries.set(i, country);
////						}
////					}
////				}
//
//                System.out.println("/////////////////////////////// " + movie);
//                movie.setLastUpdate(new Date());
//                entity = movieRepository.save(movie);
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
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Movie movie) {
//        HttpStatus httpStatus;
//        Object entity = null;
//
//        try {
//            if (movieRepository.findById(id) == null) {
//                httpStatus = HttpStatus.NO_CONTENT;
//            } else {
//                if (movieRepository.findByFrenchTitle(movie.getFrenchTitle()) != null) {
//                    entity = "Un film possède déjà ce titre";
//                    httpStatus = HttpStatus.CONFLICT;
//                } else {
//                    movie.setId(id);
//                    movie.setLastUpdate(new Date());
//                    entity = movieRepository.save(movie);
//                    httpStatus = HttpStatus.OK;
//                }
//            }
//        } catch (Exception e) {
//            entity = "Erreur serveur";
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> delete(@PathVariable Long id) {
//        HttpStatus httpStatus;
//        Object entity = null;
//
//        try {
//            if (movieRepository.findById(id) != null) {
//                movieRepository.deleteById(id);
//                entity = "Film supprimé avec succés";
//                httpStatus = HttpStatus.OK;
//            } else {
//                httpStatus = HttpStatus.NO_CONTENT;
//            }
//        } catch (Exception e) {
//            entity = "Erreur serveur";
//            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return ResponseEntity.status(httpStatus).body(entity);
//    }
//
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        HttpStatus httpStatus;
//        String message;
//
//        try {
//            store(file);
//            httpStatus = HttpStatus.OK;
//            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
//        } catch (Exception e) {
//            httpStatus = HttpStatus.EXPECTATION_FAILED;
//            message = "FAIL to upload " + file.getOriginalFilename() + "!";
//        }
//
//        return ResponseEntity.status(httpStatus).body(message);
//    }
//
//    public void store(MultipartFile file) {
//        try {
//            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
//        } catch (Exception e) {
//            throw new RuntimeException("FAIL!");
//        }
//    }
//
//}
