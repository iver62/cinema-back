package org.sid.service;

import org.sid.domain.entities.Award;
import org.sid.repository.AwardRepository;
import org.sid.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {

    private AwardRepository awardRepository;

    @Autowired
    public AwardServiceImpl(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }

    @Override
    public Award getAward(Long id) {
        return awardRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Award> getAwards(Pageable pageable) {
        return awardRepository.findAll(pageable);
    }

    @Override
    public Award createAward(Award award) {
        award.setName(Utils.capitalizeFirstLetter(award.getName()));
        return awardRepository.save(award);
    }

    @Override
    public Award updateAward(Long id, Award award) {
        award.setId(id);
        award.setName(Utils.capitalizeFirstLetter(award.getName()));
        return awardRepository.save(award);
    }

    @Override
    public void deleteAward(Long id) {
        awardRepository.deleteById(id);
    }
}
