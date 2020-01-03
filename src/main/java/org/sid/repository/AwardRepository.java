package org.sid.repository;

import org.sid.domain.entities.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award, Long> {

}
