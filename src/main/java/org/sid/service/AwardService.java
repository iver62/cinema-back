package org.sid.service;

import org.sid.domain.entities.Award;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AwardService {

    Award getAward(Long id);

    Page<Award> getAwards(Pageable pageable);

    Award createAward(Award award);

    Award updateAward(Long id, Award award);

    void deleteAward(Long id);
}
