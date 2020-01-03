package org.sid.repository;

import org.sid.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository {

    public Person findByLastnameAndFirstname(String lastname, String firstname);

    @Query("SELECT p FROM Person p WHERE p.lastname LIKE :x")
    public Page<Person> search(@Param("x") String keyword, Pageable pageable);

}
