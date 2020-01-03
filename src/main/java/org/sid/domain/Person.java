package org.sid.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sid.domain.entities.Award;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;

    private String lastname;

    private String firstname;

    private String bio;

    private Date dateOfBirth;

    private Date dateOfDeath;

    private City cityOfBirth;

    private City cityOfDeath;

    private String photo;

    private Set<Award> awards;

    private Date creationDate;

    private Date lastUpdate;

}
