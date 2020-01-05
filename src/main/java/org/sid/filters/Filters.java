package org.sid.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Filters {

    private String label;
    private Date startCreationDate;
    private Date endCreationDate;
    private Date startLastUpdate;
    private Date endLastUpdate;
    private List<Long> states;
    private List<Long> countries;
}
