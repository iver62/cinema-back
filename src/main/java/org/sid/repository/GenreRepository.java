package org.sid.repository;

import org.sid.domain.entities.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	@Query("SELECT g FROM Genre g WHERE g.name LIKE :x")
	public Page<Genre> search(@Param("x") String keyword, Pageable pageable);
	
	public Genre findByName(String name);

}
