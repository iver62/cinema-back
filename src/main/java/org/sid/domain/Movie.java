package org.sid.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sid.domain.entities.Award;
import org.sid.domain.entities.Genre;
import org.sid.domain.entities.Quote;
import org.sid.domain.entities.Screenshot;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long id;

    private String frenchTitle;

    private String originalTitle;

    private String story;

    private Date releaseDate;

    private Integer runtime;

    private Double budget;

    private Double boxOffice;

    private Integer visits;

    private String poster;

    private List<Person> directors;

    private List<Person> actors;

    private List<Person> writers;

    private List<Genre> genres;

    private List<Award> awards;

    private List<Country> countries;

    private List<Screenshot> screenshots;

    private List<Quote> quotes;

    private Date creationDate;

    private Date lastUpdate;
}
