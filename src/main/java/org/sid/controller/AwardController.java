package org.sid.controller;

import org.sid.service.AwardService;
import org.sid.domain.entities.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/awards")
public class AwardController {

    private AwardService awardService;

    @Autowired
    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public Award getAward(@PathVariable Long id) {
        return awardService.getAward(id);
    }

    /**
     * @param keyword
     * @param page
     * @param size
     * @param column
     * @param direction
     * @return
     */
    @GetMapping()
    public Page<Award> getAwards(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @RequestParam(value = "property", defaultValue = "name") final String column,
            @RequestParam(value = "direction", defaultValue = "asc") final String direction) {
        Sort.Direction dir = direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return awardService.getAwards(PageRequest.of(page, size, new Sort(dir, column)));
    }

    /**
     * @param award
     * @return
     */
    @PostMapping()
    public Award createAward(@RequestBody Award award) {
        return awardService.createAward(award);
    }

    /**
     * @param id
     * @param award
     * @return
     */
    @PutMapping(value = "{id}")
    public Award updateAward(@PathVariable Long id, @RequestBody Award award) {
        return awardService.updateAward(id, award);
    }

    /**
     * @param id
     */
    @DeleteMapping(value = "{id}")
    public void deleteAward(@PathVariable Long id) {
        awardService.deleteAward(id);
    }

}
