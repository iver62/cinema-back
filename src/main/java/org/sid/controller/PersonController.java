package org.sid.controller;

import org.sid.domain.Person;
import org.sid.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {

//    @Autowired
//    private PersonRepository personRepository;
//
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    public Person getPerson(@PathVariable Long id) {
//        return personRepository.findById(id).orElse(null);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Person> getPersons() {
//        return personRepository.findAll(new Sort(Sort.Direction.ASC, "lastname"));
//    }
//
//    @RequestMapping(value = "search", method = RequestMethod.GET)
//    public Page<Person> search(
//            @RequestParam(value = "keyword", defaultValue = "") String keyword,
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "5") int size) {
//        return personRepository.search("%" + keyword + "%", new PageRequest(page, size));
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Person save(@RequestBody Person person) {
//        return personRepository.save(person);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public Person update(@PathVariable Long id, @RequestBody Person person) {
//        person.setId(id);
//        return personRepository.save(person);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id) {
//        personRepository.deleteById(id);
//    }

}
